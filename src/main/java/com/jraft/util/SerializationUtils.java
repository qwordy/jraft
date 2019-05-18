package com.jraft.util;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.commons.io.FileUtils;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SerializationUtils {

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    private SerializationUtils() {
        // private constructor
    }

    private static <T> Schema<T> getSchema(Class<T> cls) {
        @SuppressWarnings("unchecked")
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            cachedSchema.put(cls, schema);
        }
        return schema;
    }


    public static <T> byte[] serialize(T obj) {
        @SuppressWarnings("unchecked")
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    public static <T> T deserialize(byte[] data, Class<T> cls) {
        try {
            T message = objenesis.newInstance(cls);
            Schema<T> schema = getSchema(cls);
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * @param obj: Object instance to serialize
     * @param file: To serialize file
     * @param <T>: Type of object serialized to file
     * @throws IOException
     */
    public static <T> void serializeToFile(T obj, File file) throws IOException {
        File tmpFile = new File(file.getParentFile(), String.format(".%s.tmp", file.getName()));
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(tmpFile))) {
            byte[] objBytes = serialize(obj);
            dos.writeInt(objBytes.length);
            dos.write(objBytes, 0, objBytes.length);
        }
        FileUtils.deleteQuietly(file);
        FileUtils.moveFile(tmpFile, file);
    }

    public static <T> void serializeToFile(T obj, String fileName) throws IOException {
        serializeToFile(obj, new File(fileName));
    }


    /**
     * @param file: Deserialize from file
     * @param clazz: Class of deserialized object
     * @param <T>: Type of object deserialized from file
     * @throws IOException
     */
    public static <T> T deserializeFomeFile(File file, Class<T> clazz) throws IOException {
        if (!file.exists() || !file.isFile()) {
            throw new IOException(String.format("File '%s ' isn't existed or not a file", file.getAbsolutePath()));
        }
        if (file.length() < 4) {
            throw new IOException(String.format("File '%d' is damaged for less than 4 bytes", file.getAbsolutePath()));
        }
        byte[] objBytes;
        try(DataInputStream dio = new DataInputStream(new FileInputStream(file))) {
            int dataLen = dio.readInt();
            objBytes = new byte[dataLen];
            int readBytesNum;
            int totalReadBytes = 0;
            while ((readBytesNum = dio.read(objBytes, totalReadBytes, objBytes.length - totalReadBytes)) != -1) {
                totalReadBytes += readBytesNum;
                if (totalReadBytes == objBytes.length) {
                    break;
                }
            }
            if (readBytesNum == -1) {
                throw new IOException(String.format(
                        "File '%d' is damaged for header bytes %d not equal then file bytes %d",
                        file.getAbsolutePath(),
                        dataLen, totalReadBytes));
            }
        }
        return deserialize(objBytes, clazz);
    }

    public static <T> T deserializeFomeFile(String fileName, Class<T> clazz) throws IOException {
        return deserializeFomeFile(new File(fileName), clazz);
    }

}

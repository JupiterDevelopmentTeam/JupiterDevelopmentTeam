package cn.nukkit.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

/**
 * 
 * Utils - Jupiter
 * 
 * <p>IO関連をはじめ、様々な処理を行えるユーティリティクラスです。</p>
 * 
 * Jupiter by Jupiter Development Team
 * 
 */

public class Utils {
	
	/**
	 * 
	 * @param filename ファイルパス
	 * @param content 書き込む内容
	 * 
	 * <p>writeFile - Utils</p>
	 * 
	 * <p>contentで指定した内容をファイルに書き込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static void writeFile(String fileName, String content) throws IOException {
        writeFile(fileName, new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
    }
    
	/**
	 * 
	 * @param filename ファイルパス
	 * @param content 書き込む内容(InputStream)
	 * 
	 * <p>writeFile - Utils</p>
	 * 
	 * <p>contentで指定した内容をファイルに書き込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static void writeFile(String fileName, InputStream content) throws IOException {
        writeFile(new File(fileName), content);
    }
    
	/**
	 * 
	 * @param file 書き込み先のファイルオブジェクト
	 * @param content 書き込む内容
	 * 
	 * <p>writeFile - Utils</p>
	 * 
	 * <p>contentで指定した内容をファイルに書き込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static void writeFile(File file, String content) throws IOException {
        writeFile(file, new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
    }
    
	/**
	 * 
	 * @param file 書き込み先のファイルオブジェクト
	 * @param content 書き込む内容(InputStream)
	 * 
	 * <p>writeFile - Utils</p>
	 * 
	 * <p>contentで指定した内容をファイルに書き込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static void writeFile(File file, InputStream content) throws IOException {
        if (content == null) {
            throw new IllegalArgumentException("content must not be null");
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream stream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = content.read(buffer)) != -1) {
            stream.write(buffer, 0, length);
        }
        stream.close();
        content.close();
    }
    
	/**
	 * 
	 * @param file 読み込み先のファイルオブジェクト
	 * 
	 * @return ファイルの内容
	 * 
	 * <p>readFile - Utils</p>
	 * 
	 * <p>fileで指定したファイルを読み込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static String readFile(File file) throws IOException {
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException();
        }
        return readFile(new FileInputStream(file));
    }
    
	/**
	 * 
	 * @param filename 読み込み先のファイルパス
	 * 
	 * @return ファイルの内容
	 * 
	 * <p>readFile - Utils</p>
	 * 
	 * <p>fileで指定したファイルを読み込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static String readFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists() || file.isDirectory()) {
            throw new FileNotFoundException();
        }
        return readFile(new FileInputStream(file));
    }
    
	/**
	 * 
	 * @param inputStream 読み込み先のInputStream
	 * 
	 * @return ファイルの内容
	 * 
	 * <p>readFile - Utils</p>
	 * 
	 * <p>fileで指定したファイルを読み込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static String readFile(InputStream inputStream) throws IOException {
        return readFile(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }
    
	/**
	 * 
	 * @param reader リーダー
	 * 
	 * @return ファイルの内容
	 * 
	 * <p>readFile - Utils</p>
	 * 
	 * <p>fileで指定したファイルを読み込みます。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static String readFile(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String temp;
        StringBuilder stringBuilder = new StringBuilder();
        temp = br.readLine();
        while (temp != null) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(temp);
            temp = br.readLine();
        }
        br.close();
        reader.close();
        return stringBuilder.toString();
    }
    
	/**
	 * 
	 * @param from ファイルのコピー元
	 * @param to ファイルのコピー先
	 * 
	 * <p>copyFile - Utils</p>
	 * 
	 * <p>fromで指定したファイルをtoで指定したところにコピーします。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static void copyFile(File from, File to) throws IOException {
        if (!from.exists()) {
            throw new FileNotFoundException();
        }
        if (from.isDirectory() || to.isDirectory()) {
            throw new FileNotFoundException();
        }
        FileInputStream fi = null;
        FileChannel in = null;
        FileOutputStream fo = null;
        FileChannel out = null;
        try {
            if (!to.exists()) {
                to.createNewFile();
            }
            fi = new FileInputStream(from);
            in = fi.getChannel();
            fo = new FileOutputStream(to);
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);
        } finally {
            if (fi != null) fi.close();
            if (in != null) in.close();
            if (fo != null) fo.close();
            if (out != null) out.close();
        }
    }
    
	/**
	 * 
	 * @return ダンプ内容
	 * 
	 * <p>getAllThreadDumps - Utils</p>
	 * 
	 * <p>すべてのスレッドのダンプを取得します。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static String getAllThreadDumps() {
        ThreadInfo[] threads = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
        StringBuilder builder = new StringBuilder();
        for (ThreadInfo info : threads) {
            builder.append('\n').append(info);
        }
        return builder.toString();
    }


    public static String getExceptionMessage(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static UUID dataToUUID(String... params) {
        StringBuilder builder = new StringBuilder();
        for (String param : params) {
            builder.append(param);
        }
        return UUID.nameUUIDFromBytes(builder.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static UUID dataToUUID(byte[]... params) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        for (byte[] param : params) {
            try {
                stream.write(param);
            } catch (IOException e) {
                break;
            }
        }
        return UUID.nameUUIDFromBytes(stream.toByteArray());
    }

    public static String rtrim(String s, char character) {
        int i = s.length() - 1;
        while (i >= 0 && (s.charAt(i)) == character) {
            i--;
        }
        return s.substring(0, i + 1);
    }

    public static boolean isByteArrayEmpty(final byte[] array) {
        for (byte b : array) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    public static long toRGB(byte r, byte g, byte b, byte a) {
        long result = (int) r & 0xff;
        result |= ((int) g & 0xff) << 8;
        result |= ((int) b & 0xff) << 16;
        result |= ((int) a & 0xff) << 24;
        return result & 0xFFFFFFFFL;
    }

    public static Object[][] splitArray(Object[] arrayToSplit, int chunkSize) {
        if (chunkSize <= 0) {
            return null;
        }

        int rest = arrayToSplit.length % chunkSize;
        int chunks = arrayToSplit.length / chunkSize + (rest > 0 ? 1 : 0);

        Object[][] arrays = new Object[chunks][];
        for (int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++) {
            arrays[i] = Arrays.copyOfRange(arrayToSplit, i * chunkSize, i * chunkSize + chunkSize);
        }
        if (rest > 0) {
            arrays[chunks - 1] = Arrays.copyOfRange(arrayToSplit, (chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
        }
        return arrays;
    }
    
	/**
	 * 
	 * @return 結果
	 * 
	 * <p>toInt - Utils</p>
	 * 
	 * <p>引数で指定したオブジェクトのint表現を返します。</p>
	 * 
	 * Jupiter by Jupiter Development Team
	 * 
	 */

    public static int toInt(Object number) {
        return (int) Math.round((double) number);
    }
}
package com.mibbeun.utils.utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;


import java.util.Base64;

public class ZipUtils {

	public final static int DEFAULT_BUFFER_SIZE = 256;

	public static byte[] deflate(byte[] data) {

		if (data == null) {
			return new byte[0];
		}

		Deflater compresser = new Deflater();
		compresser.setInput(data);
		compresser.finish();

		ByteArrayOutputStream out = new ByteArrayOutputStream(
				DEFAULT_BUFFER_SIZE);
		byte temp[] = new byte[DEFAULT_BUFFER_SIZE];

		for (int i = 0; !compresser.finished(); out.write(temp, 0, i)) {
			i = compresser.deflate(temp);
		}

		return out.toByteArray();
	}
	


	public static DeflaterOutputStream deflate(byte[] data, OutputStream out)
			throws IOException {

		DeflaterOutputStream dout = null;

		try {
			dout = new DeflaterOutputStream(out);
			dout.write(data, 0, data.length);
			dout.finish();
		} catch (IOException e) {
			throw e;
		}
		
		return dout;
	}

	public static byte[] inflate(byte[] data) throws DataFormatException {

		if (data == null) {
			return new byte[0];
		}

		Inflater decompresser = new Inflater();
		decompresser.setInput(data);

		ByteArrayOutputStream out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
		byte temp[] = new byte[DEFAULT_BUFFER_SIZE];

		try {
			for (int i = 0; !decompresser.finished(); out.write(temp, 0, i)) {
				i = decompresser.inflate(temp);
			}
		} catch (DataFormatException e) {
			System.out.println(e.toString());
			throw e;
		} finally {
			decompresser.end();
		}

		return out.toByteArray();
	}
	
	public static String Base64deflate(byte[] data) {

		if (data == null) {
			return null;
		}

		Deflater compresser = new Deflater();
		compresser.setInput(data);
		compresser.finish();
		//BASE64Encoder encoder = new BASE64Encoder();
		ByteArrayOutputStream out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
		byte temp[] = new byte[DEFAULT_BUFFER_SIZE];

		for (int i = 0; !compresser.finished(); out.write(temp, 0, i)) {
			i = compresser.deflate(temp);
		}
		//String AList = encoder.encode(out.toByteArray());
		byte tempA[] = out.toByteArray();
	//	String AList = encoder.encodeBuffer(tempA);
		
		//String AList = encoder.encode(tempA).replaceAll("\\r", "").replaceAll("\\n", "");
		String AList = Base64.getEncoder().encodeToString(tempA).replaceAll("\\r", "").replaceAll("\\n", "");
		return AList;
		//return out.toByteArray();
	}
	
	public static String Base64inflate(String data) throws DataFormatException {

		if (data == null) {
			return null;
		}
		byte[] Bytedata = null;
		try {
		 // BASE64Decoder decoder = new BASE64Decoder();
		  //Bytedata = decoder.decodeBuffer(data);
		  Bytedata = Base64.getDecoder().decode(data);
		} catch (Exception e) {
			System.out.println(e.toString());
			//throw e;
		} 
	
		Inflater decompresser = new Inflater();
		decompresser.setInput(Bytedata);
		ByteArrayOutputStream out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
		byte temp[] = new byte[DEFAULT_BUFFER_SIZE];
		try {
			for (int i = 0; !decompresser.finished(); out.write(temp, 0, i)) {
				i = decompresser.inflate(temp);
			}
		} catch (DataFormatException e) {
			System.out.println(e.toString());
			throw e;
		} finally {
			decompresser.end();
		}

		return out.toString();
	}	
	

	public static byte[] Base64inflateByte(byte[] data) throws DataFormatException {
		if (data == null) {
			return null;
		}
		byte[] Bytedata = null;
		try {

		  Bytedata = Base64.getDecoder().decode(data);
		  
		} catch (Exception e) {
			System.out.println(e.toString());
			//throw e;
		} 
		
        Inflater inflater = new Inflater(false);

        inflater.setInput(Bytedata);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(Bytedata.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer,0,1024);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


		return outputStream.toByteArray();
	}
	
	public static byte[] Base64inflateByte(String data) throws DataFormatException {
		if (data == null) {
			return null;
		}
		byte[] Bytedata = null;
		try {
		  //BASE64Decoder decoder = new BASE64Decoder();
		  //Bytedata = decoder.decodeBuffer(data);
		  Bytedata = Base64.getDecoder().decode(data);
		  
		} catch (Exception e) {
			System.out.println(e.toString());
			//throw e;
		} 
	
		Inflater decompresser = new Inflater();
		decompresser.setInput(Bytedata);
		ByteArrayOutputStream out = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
		byte temp[] = new byte[DEFAULT_BUFFER_SIZE];
		try {
			for (int i = 0; !decompresser.finished(); out.write(temp, 0, i)) {
				i = decompresser.inflate(temp);
			}
		} catch (DataFormatException e) {
			System.out.println(e.toString());
			throw e;
		} finally {
			decompresser.end();
		}

		return out.toByteArray();
	}
}

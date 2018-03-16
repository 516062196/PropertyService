package com.property.glory.propertyservice.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;



import android.util.Log;

public class FileImageUpload {
	private static final String TAG = "uploadFile";
	private static final int TIME_OUT = 10 * 1000000000; // ��ʱʱ��
	private static final String CHARSET = "utf-8"; // ���ñ���
	public static final String SUCCESS = "1";
	public static final String FAILURE = "0";

	/**
	 * * android�ϴ��ļ���������
	 * 
	 * @param file
	 *            ��Ҫ�ϴ����ļ�
	 * @param RequestURL
	 *            �����rul
	 * @return ������Ӧ������
	 */
	public static String uploadFile(File file, String RequestURL) {
		String BOUNDARY = UUID.randomUUID().toString(); // �߽��ʶ �������
		String PREFIX = "--", LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // ��������
		try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setDoInput(true); // ����������
			conn.setDoOutput(true); // ���������
			conn.setUseCaches(false); // ������ʹ�û���
			conn.setRequestMethod("POST"); // ����ʽ
			conn.setRequestProperty("Charset", CHARSET);
			// ���ñ���
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			if (file != null) {
				/** * ���ļ���Ϊ�գ����ļ���װ�����ϴ� */
				OutputStream outputSteam = conn.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputSteam);
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				/**
				 * �����ص�ע�⣺ name�����ֵΪ����������Ҫkey ֻ�����key �ſ��Եõ���Ӧ���ļ�
				 * filename���ļ������֣�������׺���� ����:abc.png
				 */
				sb.append("Content-Disposition: form-data; name=\"file1\"; filename=\"" + file.getName() + "\""
						+ LINE_END);
				sb.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
				dos.write(end_data);
				dos.flush();
				/**
				 * ��ȡ��Ӧ�� 200=�ɹ� ����Ӧ�ɹ�����ȡ��Ӧ����
				 */
				/* ȡ��Response���� */
				InputStream isa = conn.getInputStream();
				int ch;
				StringBuffer b = new StringBuffer();
				while ((ch = isa.read()) != -1) {
					b.append((char) ch);
				}
				/*
				 * int res = conn.getResponseCode(); Log.e(TAG, "response code:"
				 * + res); if (res == 200) { return SUCCESS; }
				 */
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FAILURE;
	}

	/**
	 * �����ڴ���ͼƬ
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String sendRequest(File file, String RequestURL) throws Exception {

		OutputStream reqStream = null;

		String BOUNDARY = UUID.randomUUID().toString(); // �߽��ʶ �������
		String PREFIX = "--", LINE_END = "\r\n";

		String CONTENT_TYPE = "multipart/form-data"; // ��������
		// String RequestURL =
		// "http://192.168.0.93:8081/ldassetQueue/siproduct/uploadtest";

		try {
			// postData = xml.getBytes("GBK");
			URL url = new URL(RequestURL);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			httpConn.setReadTimeout(10 * 10000);
			httpConn.setConnectTimeout(10 * 10000);

			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("Charset", "UTF-8"); // ���ñ���
			httpConn.setRequestProperty("connection", "keep-alive");
			// httpConn.setRequestProperty("Content-Type", CONTENT_TYPE);
			httpConn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);

			// httpsConn.setRequestProperty("Content-type",
			// "application/tlt-notify");
			// httpsConn.setRequestProperty("Content-length",
			// String.valueOf(postData.length));
			// httpsConn.setRequestProperty("Keep-alive", "false");

			if (file != null) {
				OutputStream output = httpConn.getOutputStream();

				DataOutputStream dos = new DataOutputStream(output);

				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				sb.append("Content-Disposition: form-data; name=\"file1\"; filename=\"" + file.getName() + "\""
						+ LINE_END);
				sb.append("Content-Type: application/octet-stream; charset=" + "UTF-8" + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());

				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[4096];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();

				dos.write(LINE_END.getBytes());

				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
				dos.write(end_data);
				dos.flush();
				dos.close();
				output.close();
				int res = httpConn.getResponseCode();
				// System.out.println(res);
				// return res==200?"SUCCESS":"fales";
				if (res == 200) {
					ByteArrayOutputStream ms = null;
					InputStream resStream = httpConn.getInputStream();
					ms = new ByteArrayOutputStream();
					byte[] buf = new byte[4096];
					int count;
					while ((count = resStream.read(buf, 0, buf.length)) > 0) {
						ms.write(buf, 0, count);
					}
					resStream.close();
					return new String(ms.toByteArray(), "GBK");
				} else {
					return "erro";
				}

			} else {
				return "null";
			}
			// return "fales";
			// reqStream = httpConn.getOutputStream();
			// reqStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		} finally {
			try {
				if (reqStream != null)
					reqStream.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				return "erro";
			}
		}
	}
	/**
	 * 
	 */
	public static String sendRequests(File[] file, String RequestURL) throws Exception {

		OutputStream reqStream = null;

		String BOUNDARY = UUID.randomUUID().toString(); // �߽��ʶ �������
		String PREFIX = "--", LINE_END = "\r\n";

		String CONTENT_TYPE = "multipart/form-data"; // ��������
		// String RequestURL =
		// "http://192.168.0.93:8081/ldassetQueue/siproduct/uploadtest";

		try {
			// postData = xml.getBytes("GBK");
			URL url = new URL(RequestURL);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			httpConn.setReadTimeout(10 * 10000);
			httpConn.setConnectTimeout(10 * 10000);

			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("Charset", "UTF-8"); // ���ñ���
			httpConn.setRequestProperty("connection", "keep-alive");
			// httpConn.setRequestProperty("Content-Type", CONTENT_TYPE);
			httpConn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);

			// httpsConn.setRequestProperty("Content-type",
			// "application/tlt-notify");
			// httpsConn.setRequestProperty("Content-length",
			// String.valueOf(postData.length));
			// httpsConn.setRequestProperty("Keep-alive", "false");

			if (file != null) {
				OutputStream output = httpConn.getOutputStream();

				DataOutputStream dos = new DataOutputStream(output);

				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				sb.append("Content-Disposition: form-data; name=\"file1\";");
				for (int i = 0; i < 1; i++) {
					sb.append("filename=\"" + file[i].getName() + "\""
							+ "filename=\"" + file[i+1].getName() + "\""+LINE_END);
					
				if(i==file.length){
					sb.append("Content-Type: application/octet-stream; charset=" + "UTF-8" + LINE_END);
					sb.append(LINE_END);
					dos.write(sb.toString().getBytes());

					InputStream is = new FileInputStream(file[i]);
					byte[] bytes = new byte[4096];
					int len = 0;
					while ((len = is.read(bytes)) != -1) {
						dos.write(bytes, 0, len);
					}
					is.close();

					dos.write(LINE_END.getBytes());

					byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
					dos.write(end_data);
					dos.flush();
					dos.close();
					output.close();
				}
				}
			
				
				int res = httpConn.getResponseCode();
				// System.out.println(res);
				// return res==200?"SUCCESS":"fales";
				if (res == 200) {
					ByteArrayOutputStream ms = null;
					InputStream resStream = httpConn.getInputStream();
					ms = new ByteArrayOutputStream();
					byte[] buf = new byte[4096];
					int count;
					while ((count = resStream.read(buf, 0, buf.length)) > 0) {
						ms.write(buf, 0, count);
					}
					resStream.close();
					return new String(ms.toByteArray(), "GBK");
				} else {
					return "erro";
				}

			} else {
				return "null";
			}
			// return "fales";
			// reqStream = httpConn.getOutputStream();
			// reqStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		} finally {
			try {
				if (reqStream != null)
					reqStream.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				return "erro";
			}
		}
	}
}

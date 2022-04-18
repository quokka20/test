package com.test1.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class MsgFormat implements Serializable{
	
	private String sender;
	private String recevier;
	private String contents;
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private String fileName;
	private byte[] fileData;
	private String uid;
	private String pwd;
	
	public MsgFormat() {}
	
	public MsgFormat(String uid, String pwd, String sender, String recevier, String contents, String fileName, byte[] fileData) {
		super();
		this.uid = uid;
		this.sender = sender;
		this.recevier = recevier;
		this.contents = contents;
		this.fileName = fileName;
		this.fileData = fileData;
	}
	
	public boolean loadFile(String filePath) {
		String fullPath = filePath+"/"+fileName;
		try {
			BufferedInputStream bin =new BufferedInputStream(new FileInputStream(fullPath));
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int read = 0;
			while((read=bin.read(buf))!=-1) {
				bout.write(buf,0,read);
			}
			bout.flush();
			fileData = bout.toByteArray();
			bin.close();
			bout.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveFile(String filePath) {
		try {
			FileOutputStream fout =new FileOutputStream(filePath+"/"+fileName);
			
			fout.write(fileData);
			
			fout.close();
			System.out.println("파일 저장 성공");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void print() {
		System.out.printf("%s %s %s %s %d byte \n",sender,recevier,contents,fileName,fileData.length);
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecevier() {
		return recevier;
	}

	public void setRecevier(String recevier) {
		this.recevier = recevier;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	
	
}

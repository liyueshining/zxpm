package com.zxpm.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements RequestAware,SessionAware{

	Map<String, Object> request;
	Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	private File doc;
	private String docFileName;
	private String docContentType;
	public void setDoc(File doc){
		this.doc = doc;
	}
	public void setDocFileName(String docFileName){
		this.docFileName = docFileName;
	}
	public void setDocContentType(String docContentType){
		this.docContentType = docContentType;
	}
	
	public String execute() throws Exception{
		//得到当前web工程下的/pic目录的在本机的绝对路径
		//如果没有这个文件夹则会创建
		String targetDirectory = ServletActionContext.getServletContext().getRealPath("/pic");
		//重命名上传文件
		String targetFileName = generateFileName(docFileName);
		//在指定目录创建文件
		File target = new File(targetDirectory, targetFileName);
		//把要上传的文件copy过去
		FileUtils.copyFile(doc, target);
		//将文件相对路径存入session中，以便后面写入数据库表中
		session.put("filepath", "pic/"+targetFileName);
		System.out.println("filepath----"+session.get("filepath"));
		return "success";
	}
	
	//重命名上传的文件
	public String generateFileName(String fileName){
		String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int random = new Random().nextInt(10000);
		System.out.println("fileName:"+fileName);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate+random+extension;
	}
	public String getDocFileName(){
		return docFileName;
	}

}

package org.discobots.powerup.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/* Based off of 1114's 2015 Logger & Debugger */

public class Debugger {

	private static Debugger instance;
	
	private BufferedWriter writer;
	private boolean debugging = false;
	private final String debuggerBoolean = "Debugging";
	private String fileName = "";
	private final String DebuggerFileName = "Debugger File Name: ";
	private int max = 0;
	
	private String path;
	
	public static Debugger getInstance() {
		if(instance == null) {
			instance = new Debugger();
		}
		return instance;
	}
	
	private Debugger() {
		SmartDashboard.putBoolean(this.debuggerBoolean, this.debugging);
		this.debugging = SmartDashboard.getBoolean(this.debuggerBoolean, false);
		SmartDashboard.putString(this.DebuggerFileName, this.fileName);
		this.fileName = SmartDashboard.getString(this.DebuggerFileName, "");
		File f = new File("/logs");
		//File f = new File(System.getProperty("user.home"), "Desktop");
		if(!f.exists()) {
			f.mkdir();
		}
		
		File[] files = new File("/logs").listFiles();
		if(files != null) {
			for(File file : files) {
				if(file.isFile()) {
					System.out.println(file.getName());
					try {
						int index = Integer.parseInt(file.getName().split("_")[0]);
						if(index > max) {
							max = index;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			max = 0;
		}
	}
	
	public void openFile() {
		if(this.wantToLog()) {
			try {
				path = this.getPath();
				this.writer = new BufferedWriter(new FileWriter(path));
				this.writer.write("");
				this.writer.newLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getPath() {
		this.fileName = SmartDashboard.getString(DebuggerFileName, "");
		if(this.fileName != null){ 
        	return String.format("/logs/%d_%s.txt",++this.max,this.fileName);
        } else {
            return String.format("/logs/%d_log.txt", ++this.max);
        }
	}
	
	public void log(String msg, String flag) {
		if(this.wantToLog()) {
			try {
				this.writer.write("[" + flag + "] " + msg + "\n");
				System.out.println("[" + flag + "] " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void log(String msg) {
		log(msg, "DEBUG");
	}
	
	public void log(int msg, String flag) {
		log(""+msg, flag);
	}
	
	public void log(int msg) {
		log(""+msg);
	}
	
	public void log(double msg, String flag) {
		log(""+msg, flag);
	}
	
	public void log(double msg) {
		log(""+msg);
	}
	
	public void log(float msg, String flag) {
		log(""+msg, flag);
	}
	
	public void log(float msg) {
		log(""+msg);
	}
	
	public void log(long msg, String flag) {
		log(""+msg, flag);
	}
	
	public void log(long msg) {
		log(""+msg);
	}
	
	public void log(boolean msg, String flag) {
		log(""+msg, flag);
	}
	
	public void log(boolean msg) {
		log(""+msg);
	}
	
	public boolean wantToLog() {
		this.debugging = SmartDashboard.getBoolean(this.debuggerBoolean, false);
		return this.debugging;
	}
	
	public void close() {
		if(this.wantToLog()) {
			if(this.writer != null) {
				try {
					this.writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

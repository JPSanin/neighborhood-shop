package model;

public class Person {

	//Constants representing the types of documents
	private final static int TI=1;
	private final static int CC=2;
	private final static int PP=3;
	private final static int FC=4;
	private int docType;
	private int docNum;

	public Person(int docType, int docNum) {
		switch(docType) {
		case TI:
			this.docType=TI;
			break;

		case CC:
			this.docType=CC;
			break;

		case PP:
			this.docType=PP;
			break;

		case FC:
			this.docType=FC;
			break;
		}

		this.docNum=docNum;
	}

	public String printInfo() {
		String info="";
		info+="Document Type:";
		switch(docType) {
		case TI:
			info+=" Identity Card";
			break;

		case CC:
			info+=" Citizen Card";
			break;

		case PP:
			info+=" Passport";
			break;

		case FC:
			info+=" Foreigner Citizen Card";
			break;
		}
		info+="\n Document Number: "+docNum;
		
		
		return info;
	}


	public int getDocType() {
		return docType;
	}
	public void setDocType(int docType) {
		this.docType = docType;
	}
	public int getDocNum() {
		return docNum;
	}
	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}

}

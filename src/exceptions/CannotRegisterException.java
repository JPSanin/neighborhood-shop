package exceptions;

@SuppressWarnings("serial")
public class CannotRegisterException extends Exception {

	private int docType;
	private int docNum;
	
	public CannotRegisterException( int docType,int docNum) {
		super("Cannot register");
		this.docType=docType;
		this.docNum=docNum;
	}

	public int getDocType() {
		return docType;
	}

	public int getDocNum() {
		return docNum;
	}
}

package com.example.definekeyboard;

import java.util.List;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * 
 * @author tr
 * @time 2014-3-6
 * @description �Զ���Ի��򹤾��࣬���ڿ��Ƽ���
 */
public class DefineKeyboardUtil {
	private Context mContext;
	private EditText mEditText;
	private Keyboard keyboard_all; //ȫ���̶���
	private Keyboard keyboard_number; //���ּ��̶���
	private Keyboard keyboard_number2; //���ּ��̶���
	private Keyboard keyboard_number3; //���ּ��̶���
	private StockKeyboardView mKeyboardView; //����������̵���ͼ����������Ⱦ���ͼ�ⰴ���ʹ�������

	public boolean isNum = true;// �Ƿ����ݼ���
	public boolean isUpper = false;// �Ƿ��д
	public DefineKeyboardUtil(Context mContext,EditText mEditText,StockKeyboardView mKeyboardView){
		this.mContext = mContext;
		this.mEditText = mEditText;
		this.mKeyboardView = mKeyboardView;
		
		keyboard_all = new Keyboard(mContext, R.xml.qwerty);
		keyboard_number = new Keyboard(mContext, R.xml.symbols);
		keyboard_number2 = new Keyboard(mContext, R.xml.symbols);
		keyboard_number3 = new Keyboard(mContext, R.xml.symbols);
		randomNumKey();
		this.mKeyboardView.setKeyboard(keyboard_number);
		this.mKeyboardView.setEnabled(true);
		this.mKeyboardView.setPreviewEnabled(true);
		this.mKeyboardView.setOnKeyboardActionListener(listener);
		/**���û���ü��ķ�������*/
//		this.mKeyboardView.setPreviewEnabled(false);
		
	}
	
	private OnKeyboardActionListener listener = new OnKeyboardActionListener() {
		
		@Override
		public void swipeUp() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void swipeRight() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void swipeLeft() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void swipeDown() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onText(CharSequence text) {
			// TODO Auto-generated method stub
			
		}
		
		//�����ͷ�ʱ��������
		@Override
		public void onRelease(int primaryCode) {
			// TODO Auto-generated method stub
			if(primaryCode == Keyboard.KEYCODE_CANCEL){//���
				hideKeyboard();
			}
			
			
		}

		//�������ʱ��������
		@Override
		public void onPress(int primaryCode) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			// TODO Auto-generated method stub
			Editable editable = mEditText.getText();
			int start = mEditText.getSelectionStart();
			switch(primaryCode){ //����codes����
//			case Keyboard.KEYCODE_CANCEL://���
//				hideKeyboard();
//				break;
			case Keyboard.KEYCODE_DELETE://ɾ��
				if(editable != null && editable.length() > 0){
					if(start > 0){
						editable.delete(start-1, start);//��ʼ������λ��
					}
				}
				break;
			case Keyboard.KEYCODE_SHIFT: //��Сд�л�
				changeKey();
				mKeyboardView.setKeyboard(keyboard_all);
				break;
			case Keyboard.KEYCODE_MODE_CHANGE:
				changeKeyTONum();
				break;
			default:
				editable.insert(start, Character.toString((char) primaryCode));
				break;
			}
		}
	};
	
	/**
	 * ����������������
	 */
	public void clearEditTextContent(){
		if(mEditText != null){
			Editable editable = mEditText.getText();
			int start = mEditText.getSelectionStart();
			if(start > 0){
				editable.clear();
			}
		}
		
	}
	
	
	/**
	 * ��ʾ����
	 */
	public void showKeyboard(){
		int visibility = mKeyboardView.getVisibility();
		if(visibility == View.GONE || visibility == View.INVISIBLE){
			mKeyboardView.setVisibility(View.VISIBLE);
		}
	}
	
	/**
	 * ���ؼ���
	 */
	public void hideKeyboard(){
		int visibility = mKeyboardView.getVisibility();
		if(visibility == View.VISIBLE ){
			mKeyboardView.setVisibility(View.INVISIBLE);
		}
	}
	
	/**
	 * �жϵ�ǰ�����Ƿ�ɼ�
	 * @return trueΪ���̿ɼ���falseΪ���̲��ɼ�
	 */ 
	public boolean isShowKeyboard(){
		int visibility = mKeyboardView.getVisibility();
		if(visibility == View.VISIBLE ){
			return true;
		}
		return false;
	}
	
	/**
	 * �л����̴�Сд��ĸ
	 * ����ascii����֪��Сд��ĸ = ��д��ĸ+32;
	 */
	private void changeKey(){
		List<Key> keyList = keyboard_all.getKeys();
		if(isUpper){//���Ϊ���ʾ��ǰΪ��д�����л�ΪСд
			isUpper = false;
			for (Key key : keyList) {
				if(key.label != null && isWord(key.label.toString())){
					key.label = key.label.toString().toLowerCase();
					key.codes[0] = key.codes[0]+32;
				}
			}
		}else{//���Ϊ�ٱ�ʾ��ǰΪСд�����л�Ϊ��д
			isUpper = true;
			for (Key key : keyList) {
				if(key.label != null && isWord(key.label.toString())){
					key.label = key.label.toString().toUpperCase();
					key.codes[0] = key.codes[0]-32;
				}
			}
		}
	}
	
	/**
	 * ������ּ���,�������LABEL�в��ܴ���ͼƬ�������������λ�����лᱨ��
	 */
	private void randomNumKey(){
		List<Key> keyList = keyboard_number.getKeys();
		int size = keyList.size();
		for (int i = 0; i < size; i++) {
			int random_a = (int)(Math.random()*(size));
			int random_b = (int)(Math.random()*(size));
			
			int code = keyList.get(random_a).codes[0];
			CharSequence label = keyList.get(random_a).label;
			
			keyList.get(random_a).codes[0] = keyList.get(random_b).codes[0];
			keyList.get(random_a).label = keyList.get(random_b).label;
			
			keyList.get(random_b).codes[0] = code;
			keyList.get(random_b).label = label;
			
		}
	}
	
	/**
	 * ������ּ���,�������LABEL�в��ܴ���ͼƬ�������������λ�����лᱨ��
	 */
	private void randomQwertyKey(){
		List<Key> keyList = keyboard_all.getKeys();
		int size = keyList.size();
		for (int i = 0; i < size; i++) {
			int random_a = (int)(Math.random()*(size));
			int random_b = (int)(Math.random()*(size));
			
			
			
			int code = keyList.get(random_a).codes[0];
			CharSequence label = keyList.get(random_a).label;
			
			int code_b = keyList.get(random_b).codes[0] ;
			CharSequence label_b = keyList.get(random_b).label ;
			if( code > 96 & code < 123 && code_b > 97 && code< 123)
			{
				keyList.get(random_a).codes[0] = code_b;
				keyList.get(random_a).label = label_b ;
				
				keyList.get(random_b).codes[0] = code;
				keyList.get(random_b).label = label;
			}
		}
	}
	
	/**
	 * ���ּ����л�
	 */
	private void changeKeyTONum(){
		if(isNum){ //��ǰΪ���ּ���,�л�Ϊȫ��ĸ����
			isNum = false;
			randomQwertyKey();
			mKeyboardView.setKeyboard(keyboard_all);
		}else{//��ǰΪȫ��ĸ���̣��л�Ϊ���ּ���
			isNum = true;
			randomNumKey();
			mKeyboardView.setKeyboard(keyboard_number);
		}
	}
	
	/**�ж��Ƿ�Ϊ��ĸ
	 * 
	 * @param str ���жϵ��ַ���
	 */ 
	private boolean isWord(String str){
		String wordStr = "abcdefghijklmnopqrstuvwxyz";
		if(wordStr.indexOf(str.toLowerCase()) > -1){
			return true;
		}
		return false;
	}
	
	
	
}

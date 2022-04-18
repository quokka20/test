package com.test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamEx_test {

	/* �ؽ�Ʈ ����(member.txt)�� ������� CRUD ����
	 * ���α׷��� ���۵Ǹ� ȭ�鿡 ȸ����� 5�������� ǥ�õȴ�
	 * ����Ʈ �ϴܿ� �޴��� ǥ�õȴ�(���(s), �˻�(f), �߰�(a), ����(u), ����(d), ����(x))
	 * �ؽ�Ʈ ���Ͽ� ����� ������ ���� : num|name|phone|email
	 */
	
	// ���� ��ġ
	static File src = new File("C:/Users/ysmin/Javatest/member.txt");
	
	// ����� ���� �ҷ�����
	static List<Member> fileLoad() throws Exception {

			FileReader fr = new FileReader(src);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			List<Member> list = new ArrayList<>();
			while((line = br.readLine()) != null) {
				String[] token = line.split("\\|");
				int num = Integer.parseInt(token[0]);
				list.add(new Member(num,token[1],token[2],token[3]));
			}
			br.close();
			return list;
	}
	
	// ����Ʈ ȭ�鿡 �����ֱ�
	static void showList(List<Member> list) {
		for(int i = 0; i<list.size(); i++) {
			list.get(i).printMem();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package project7;

import java.util.*;

public class Game {
	List<Poker> allCards = new ArrayList<Poker>();
	List<Player> players = new ArrayList<Player>();
	ArrayList<String> designs = new ArrayList<String>(Arrays.asList("����","����","÷��","��Ƭ"));  
   	ArrayList<String> points = new ArrayList<String>(Arrays.asList("A","K","Q","J","10","9","8","7","6","5","4","3","2"));

	public static void main(String[] args) {
		Game gm = new Game();
		gm.setCards();
		System.out.println();
		System.out.println("----------��ʼϴ��----------");
		Collections.shuffle(gm.allCards);//Collections��shuffle()������������������б�����
		System.out.println("----------ϴ�ƽ���----------");
		System.out.println("----------�������----------");
		System.out.println("�������1λ��ҵ�ID������:");
		gm.creatPlayer(1);
		gm.players.add(0,new Player(gm.id,gm.name));
		System.out.println("�������2λ��ҵ�ID������:");
		gm.creatPlayer(2);
		gm.players.add(1,new Player(gm.id,gm.name));
		gm.deal();
		System.out.println("--------��ʼ��Ϸ--------");
		gm.playerPk();
	}

	/**
	 * �����˿���
	 * @param args
	 */
	public void setCards() {
		System.out.println("----------�����˿���----------");
		for(int i = 0;i < points.size();i++) {
			for (int j = 0;j < 4;j++) {
				Poker poker = new Poker(designs.get(j),points.get(i));
				allCards.add(poker);
			}
		}
		System.out.println("----------�˿��ƴ����ɹ�----------");
		for(Poker card:allCards) {
			System.out.print(card.getDesign()+card.getPoint()+",");
		}
	}
	/**
	 * �������
	 * @param args
	 */
	int id=0;  
    String name;  
    public void creatPlayer(int num){  
        System.out.println("���������ID:");  
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);    
        //�����쳣  
        try {  
            id = input.nextInt();  
        } catch (Exception e) {  
            System.out.println("������һ������ID"); 
            input.next();
            this.creatPlayer(num);
            return;
        
        }         
        System.out.println("�������������:");
        name =input.next();
    }  
	/**
	 * ����
	 * @param args
	 */
	public void deal() {
		System.out.println("********��ʼ����********");
		for(int i = 0;i < 2;i++) {
			for(int j = 0;j < 2;j++) {
			System.out.println("----���:" + players.get(j).getName() + "-����");
			players.get(j).handcard.add(allCards.get(0));
			allCards.remove(0);
			}
		}
		System.out.println("********���ƽ���!********");
	}
	/**
	 * �Ƚ������С
	 * @param args
	 */
	public Poker pkCard(Poker a,Poker b) {
        if(points.indexOf(a.getPoint()) < points.indexOf(b.getPoint())) {
			return a;
		}else if(points.indexOf(a.getPoint()) == points.indexOf(b.getPoint())) {
			if(designs.indexOf(a.getDesign())< designs.indexOf(b.getDesign())){
				return a;
			}else {
				return b;
			}
		} else{
			return b;
		}
	}
	/**
	 * ���Pk
	 * @param args
	 */
	public void playerPk() {
			Poker temp[] = new Poker[2];
			for(int i = 0;i < players.size();i++) {
				Poker handpoker[] = new Poker[2];
				for(int j = 0;j < players.get(i).handcard.size();j++) {
					handpoker[j] = players.get(i).handcard.get(j);
				}
				temp[i] = pkCard(handpoker[0],handpoker[1]);
				System.out.println("���:" + players.get(i).getName() + "��������Ϊ:" + 
									temp[i].getDesign() + temp[i].getPoint());
			}
			if(pkCard(temp[0],temp[1]) == temp[0]){
				System.out.println("--------���" +players.get(0).getName() + "��ʤ!--------");
			}else {
				System.out.println("--------���" +players.get(1).getName() + "��ʤ!--------");
			}
			System.out.println("--------��Ҹ��Ե�����Ϊ:--------");	
			
			for(int i = 0;i < players.size();i++) {
				Poker handpoker[] = new Poker[2];
				for(int j = 0;j < players.get(i).handcard.size();j++) {
					handpoker[j] = players.get(i).handcard.get(j);
				}
				System.out.println( players.get(i).getName() + ":" 
									+ handpoker[0].getDesign() 
									+ handpoker[0].getPoint()
									+" " + handpoker[1].getDesign() 
									+ handpoker[1].getPoint());
			}
	}	
}

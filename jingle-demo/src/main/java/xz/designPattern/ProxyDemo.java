package xz.designPattern;

/**
 * Created by Jinhua on 2016/10/25.
 */
public class ProxyDemo {
	public static void main(String[] args) {
		TicketSeller seller = new RailwayAgency();
		seller.sellTicket();
	}
}

//可售票接口
interface TicketSeller {
	void sellTicket();
}

//火车站
class RailwayStation implements TicketSeller {
	public void sellTicket() {
		System.out.println("A ticket was sold,");
	}
}

//代售点
class RailwayAgency implements TicketSeller {
	RailwayStation station = new RailwayStation();
	public void sellTicket() {
		station.sellTicket();
		System.out.println("and the ticket is sold by agency");
	}
}
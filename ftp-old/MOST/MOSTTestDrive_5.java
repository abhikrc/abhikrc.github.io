package MOST;
import MOST.*;
import java.util.*;

public class MOSTTestDrive_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//CR is empty, NM.Addr={0x0}, 
		//NS1.Add={0x1}, NS1.FB={<0, 0x1, 0x1, 0x1>}, 
		//NS2.Add={0x2}, 
		//NS2.FB={<1, 0x2, 0x2, 0x2>, <1, 0x2, 0x2, 0xffff>, 
		//<1, 0x2, 0x2, 0x2>}
		
		//initialize node address list for nm and ns
		//0xFFFF as invalid, others as valid
		int [] nmAddr = new int[] {0x0};
		int [] nsAddr1 = new int[] {0x1};
		int [] nsAddr2 = new int[] {0x2};
		//initialize FBlockIDs for ns
		ArrayList nsFBlockIDs1 = new ArrayList();
		FBlockIDEntry fb1 = new FBlockIDEntry();
		fb1.nodepos = 0; //start from 0
		fb1.NodeAddress = 0x1;
		fb1.FBlockID = 0x1;
		fb1.InstID = 0x1;
		nsFBlockIDs1.add(fb1);
		
		ArrayList nsFBlockIDs2 = new ArrayList();
		FBlockIDEntry fb2_1 = new FBlockIDEntry();
		fb2_1.nodepos = 1;
		fb2_1.NodeAddress = 0x2;
		fb2_1.FBlockID = 0x2;
		fb2_1.InstID = 0x2;
		nsFBlockIDs2.add(fb2_1);
		FBlockIDEntry fb2_2 = new FBlockIDEntry();
		fb2_2.nodepos = 1;
		fb2_2.NodeAddress = 0x2;
		fb2_2.FBlockID = 0x2;
		fb2_2.InstID = 0xffff;
		nsFBlockIDs2.add(fb2_2);
		FBlockIDEntry fb2_3 = new FBlockIDEntry();
		fb2_3.nodepos = 1;
		fb2_3.NodeAddress = 0x2;
		fb2_3.FBlockID = 0x2;
		fb2_3.InstID = 0x2;
		nsFBlockIDs2.add(fb2_3);
		
		//initialize CentralRegistry
		//if set, sequence must be the same as created ns
		//CentralRegistry.insertNewEntry(entry);
		
		//initialize system
		NetworkMaster.createInstance(nmAddr);
		NetworkMaster nm = NetworkMaster.getInstance();
		NetworkSlave ns1 = new NetworkSlave(nsAddr1);
		ns1.FBlockIDList = nsFBlockIDs1;
		MOSTSystem.slaves.add(ns1);
		
		NetworkSlave ns2 = new NetworkSlave(nsAddr2);
		ns2.FBlockIDList = nsFBlockIDs2;
		MOSTSystem.slaves.add(ns2);
		
		//notice:
		//NM:
		// 1. Error in registration:
		//    slave node address is invalid (0xFFFF or 0x0)
		//    or duplicate with other existing addresses
		// 2. Error in InstID:
		//    InstID is invalid (0xFFFF)
		
		ns1.NetOn();
		ns2.NetOn();
		
		nm.NetOn();
		
		//perform rescan manually
		nm.ManualRescan();
		nm.ManualRescan();

	}

}

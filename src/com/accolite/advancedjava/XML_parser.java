package com.accolite.advancedjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



class License 
{
	

	String Date_Status_Effective, License_Expiration_Date, License_Issue_Date,License_Class, State_Code,License_Class_Code, License_Number, State_ID;
	String NIPR;
	License(String NIPR,String Date_Status_Effective,String License_Class,String License_Class_Code,String License_Expiration_Date,String License_Issue_Date,String License_Number,String State_Code) {
		super();
		this.Date_Status_Effective = Date_Status_Effective;
		this.License_Expiration_Date = License_Expiration_Date;
		this.License_Issue_Date = License_Issue_Date;
		this.License_Class = License_Class;
		this.State_Code = State_Code;
		this.License_Class_Code = License_Class_Code;
		this.License_Number = License_Number;
		this.NIPR = NIPR;
	}
	
	void display_output()
	{
		System.out.println("Date_Status_Effective :"+Date_Status_Effective+"License_Expiration_Date :"+License_Expiration_Date +"License_Issue_Date :" +License_Issue_Date +"License_Class :"+License_Issue_Date +"State_Code :" +State_Code+ "License_Class_Code ;" +License_Class_Code+ "License_Number :"+License_Number);
	}
	
	public boolean isEqual(License l)
	{	if(l.Date_Status_Effective == null) return false;
		else if(!NIPR.equals(l.NIPR)) return false;
		if(this.State_Code.equals(l.State_Code) && this.License_Number.equals(l.License_Number) && this.Date_Status_Effective.equals(l.Date_Status_Effective)) return true;
		else
			return false;
	}

	public String toString(License l) {
		// TODO Auto-generated method stub
		return "NIPR nu:" + l.NIPR+"Date_Status_Effective :"+ l.Date_Status_Effective +" License_Expiration_Date :"+l.License_Expiration_Date +" License_Issue_Date :" +l.License_Issue_Date +" License_Class :"+l.License_Issue_Date +" State_Code :" +l.State_Code+ " License_Class_Code :" +l.License_Class_Code+ " License_Number :"+l.License_Number;
		
	}
	
	public boolean contains(License l) {
		if(this.NIPR.equals(l.NIPR) && this.State_Code.equals(l.State_Code) && this.License_Number.equals(l.License_Number) && this.Date_Status_Effective.equals(l.Date_Status_Effective)) return true;
		else return false;
	}
}

class LOA extends License{
	
	String LOA_Issue_Date,LOA_Name,LOA_Status;
	
	LOA(String NIPR,String LOA_Issue_Date,String LOA_Name,String LOA_Status,String Date_Status_Effective,String License_Class,String License_Class_Code,String License_Expiration_Date,String License_Issue_Date,String License_Number,String State_Code){
		super(NIPR,Date_Status_Effective,License_Expiration_Date, License_Issue_Date, License_Class, State_Code,License_Class_Code,License_Number);
		this.LOA_Issue_Date = LOA_Issue_Date;
		this.LOA_Name = LOA_Name;
		this.LOA_Status = LOA_Status;
		
	}
	
	void display_output()
	{
		System.out.println("LOA_Issue_Date :"+LOA_Issue_Date+"LOA_Name :" +LOA_Name+ "LOA_Status :"+LOA_Status);
		
	}

	public String toString(LOA l) {
		// TODO Auto-generated method stub
		return "NIPR nu:" + l.NIPR + " Date_Status_Effective :"+ l.Date_Status_Effective +" License_Expiration_Date :"+l.License_Expiration_Date +" License_Issue_Date :" +l.License_Issue_Date +" License_Class :"+l.License_Issue_Date +" State_Code :" +l.State_Code+ " License_Class_Code :" +l.License_Class_Code+ " License_Number :"+l.License_Number+" LOA_Issue_Date :"+l.LOA_Issue_Date+" LOA_Name :" +l.LOA_Name+ " LOA_Status :"+l.LOA_Status;
		
	}
	
}
public class XML_parser {

	
	
	public static void main(String[] args) throws ParserConfigurationException, IOException {
		File input1 = new File("C:\\\\Users\\\\Hyderabad-Intern\\\\eclipse-workspace\\\\XML_parsing_assignment\\\\src\\\\com\\\\accolite\\\\advancedjava\\\\ex1.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		
		BufferedWriter match =null;
		BufferedWriter no_match1 = null;
		BufferedWriter no_match2 = null;
		try {
		 match = new BufferedWriter(new FileWriter("C:\\\\Users\\\\Hyderabad-Intern\\\\eclipse-workspace\\\\XML_parsing_assignment\\\\src\\\\com\\\\accolite\\\\advancedjava\\\\match.csv"));
		 no_match1 = new BufferedWriter(new FileWriter("C:\\\\Users\\\\Hyderabad-Intern\\\\eclipse-workspace\\\\XML_parsing_assignment\\\\src\\\\com\\\\accolite\\\\advancedjava\\\\no_match1.csv"));
		 no_match2 = new BufferedWriter(new FileWriter("C:\\\\Users\\\\Hyderabad-Intern\\\\eclipse-workspace\\\\XML_parsing_assignment\\\\src\\\\com\\\\accolite\\\\advancedjava\\\\no_match2.csv"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Output File/Files not found");
			System.exit(1);
		}
		
		
		 ArrayList<License> l1=new ArrayList<License>();
		try {
			
			doc = dBuilder.parse(input1);
			NodeList node_List = doc.getElementsByTagName("CSR_Producer");
			
			for (int temp = 0; temp < node_List.getLength(); temp++) {
				Node n_Node = node_List.item(temp);
				if (n_Node.getNodeType() == Node.ELEMENT_NODE) {
					Element csrpElement = (Element) n_Node;
					
					NodeList license = csrpElement.getElementsByTagName("License");
					String NIPRNumber=csrpElement.getAttribute("NIPR_Number");
		            
		           
		            
					for(int temp2 = 0; temp2 < license.getLength(); temp2++ ){
						
						Node license_node= license.item(temp2);
						
						Element li_ele = (Element) license_node;	
						        
			            String Date_Status_Effective=li_ele.getAttribute("Date_Status_Effective");
			            String License_Class=li_ele.getAttribute("License_Class");
			            String License_Class_Code=li_ele.getAttribute("License_Class_Code");
			            String License_Expiration_Date=li_ele.getAttribute("License_Expiration_Date");
			            String License_Issue_Date=li_ele.getAttribute("License_Issue_Date");
			            String License_Number=li_ele.getAttribute("License_Number");
			            String State_Code=li_ele.getAttribute("State_Code");
			            License l = new License(NIPRNumber,Date_Status_Effective,License_Expiration_Date, License_Issue_Date, License_Class, State_Code,License_Class_Code,License_Number);
			            l1.add(l);
			  
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("error occurred"+ e);
		}
		
		 for(int i = 0; i < l1.size(); i++) {
	            System.out.println(l1.get(i).toString(l1.get(i)));
	        }

		
		File input2 = new File("C:\\\\Users\\\\Hyderabad-Intern\\\\eclipse-workspace\\\\XML_parsing_assignment\\\\src\\\\com\\\\accolite\\\\advancedjava\\\\ex2.xml");
		Document doc2 = null;
		System.out.println("hjhcjh2");
		 ArrayList<LOA> l3=new ArrayList<LOA>();
		try {
			doc2 = dBuilder.parse(input2);
			NodeList node_List = doc2.getElementsByTagName("CSR_Producer");
			
			for (int temp = 0; temp < node_List.getLength(); temp++) {
				Node n_Node = node_List.item(temp);
				if (n_Node.getNodeType() == Node.ELEMENT_NODE) {
					Element csrpElement = (Element) n_Node;
					
					NodeList license = csrpElement.getElementsByTagName("License");
					String NIPRNumber=csrpElement.getAttribute("NIPR_Number");
		            
		            ArrayList<License> l2=new ArrayList<License>();
		            
					for(int temp2 = 0; temp2 < license.getLength(); temp2++ ){
						
						Node license_node= license.item(temp2);
						
						Element li_ele = (Element) license_node;	
						        
			            String Date_Status_Effective=li_ele.getAttribute("Date_Status_Effective");
			            String License_Class=li_ele.getAttribute("License_Class");
			            String License_Class_Code=li_ele.getAttribute("License_Class_Code");
			            String License_Expiration_Date=li_ele.getAttribute("License_Expiration_Date");
			            String License_Issue_Date=li_ele.getAttribute("License_Issue_Date");
			            String License_Number=li_ele.getAttribute("License_Number");
			            String State_Code=li_ele.getAttribute("State_Code");
			            License l = new License(NIPRNumber,Date_Status_Effective,License_Expiration_Date, License_Issue_Date, License_Class, State_Code,License_Class_Code,License_Number);
			            NodeList loa_list = li_ele.getElementsByTagName("LOA");
			            //l2.add(l);
			           
			            for(int temp3 =0;temp3 < loa_list.getLength();temp3++){
			            	
			            	Node LOA=(Node)loa_list.item(temp3);
		            		Element LOAelement=(Element)LOA;
		            		String LOA_Issue_Date=LOAelement.getAttribute("LOA_Issue_Date");
		            		String LOA_Name=LOAelement.getAttribute("LOA_Name");
		            		String status=LOAelement.getAttribute("LOA_Status");
		            		LOA loa_=new LOA(NIPRNumber,Date_Status_Effective,License_Expiration_Date, License_Issue_Date, License_Class, State_Code,License_Class_Code,License_Number,LOA_Issue_Date,LOA_Name,status);
		            		int flag = 0;
		            		for(int r = 0;r < l1.size();r++) {
		            			if(l1.get(r).isEqual(l)) {
		            			//System.out.println("objext"+loa_.toString());
		            				match.write(loa_.toString(loa_));
		            				match.write("\n");
		            				flag = 1;
		            				break;
		            			}
		            		}
		            			if(flag == 0) {
		            				try {
		            			
		            					no_match1.write(loa_.toString(loa_));
		            					no_match1.write("\n");
		            				}
		            				catch(IOException e) {
		            					System.out.println("error!!"+e);
		            				}
		            			}
		            			
		            		
		            		l3.add(loa_);
		            		
			            }
					}
				}
			}
		}
		catch(Exception e) {
			
			System.out.println("error occurred"+ e);
		}
		
		 for(int i = 0; i < l3.size(); i++) {
	            System.out.println(l3.get(i).toString(l3.get(i)));
	        }
		
		System.out.println("hjhcjh");
		for(int i=0;i<l1.size();i++)
		{
			License lic = l1.get(i);
			if (!l3.contains(lic))
			{
				no_match2.write(lic.toString(lic));
				no_match2.write("\n");
			}
		}
				
		match.close();
		no_match1.close();
		no_match2.close();
					
	}

}

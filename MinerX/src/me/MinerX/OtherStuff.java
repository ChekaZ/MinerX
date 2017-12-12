package me.MinerX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;



public class OtherStuff {
	public static String pFTCPriceinUSD = null;
	public static String pFTCDiff = null;
	public static boolean pFTCPriceinUSDisPulled = false;


	public static void getFTCPriceUSD() throws IOException{

		final String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.8.1.12) Gecko/20080201 Firefox/2.0.0.12";
		try {
			URL url = new URL("https://api.coinmarketcap.com/v1/ticker/trezarcoin/");
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("User-Agent", userAgent);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			String pricefinal = "";
			boolean findprice = false;
			while (((str = in.readLine()) != null ) && !findprice) {
				if(str.contains("price_usd")){
					pricefinal = str.trim().replace("\"price_usd\": \"","");
					pricefinal = pricefinal.trim().replace("\",","");
					findprice = true;
					System.out.println(pricefinal);
				}
			} 
			in.close(); 
			pFTCPriceinUSD ="1 TZC = "+ pricefinal + "$";

		} catch (MalformedURLException e) 
		{
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "You need to be connected to the Internet to be able to mine");
			System.exit(0);
		} 

		pFTCPriceinUSDisPulled = true;
	}

	public static void getFTCDiff(){

		final String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.8.1.12) Gecko/20080201 Firefox/2.0.0.12";
		try {
			URL url = new URL("http://tzc.explorerz.top:3004/api/getdifficulty");
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("User-Agent", userAgent);
			String split = "";
			boolean diff = false;
			String difficulty = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while(((split = in.readLine()) != null) && !diff){
				if(split.contains("proof-of-work")){
					difficulty = split.trim().replace("\"proof-of-work\":","");
					difficulty = difficulty.trim().replace(",","");
					diff = true;
				}
			}
			in.close(); 
			pFTCDiff ="Difficulty: "+ difficulty;
		} catch (MalformedURLException e) 
		{
		} 
		catch (IOException e) 
		{
		} 
	}

	public static void poolInfoFTCMuddy() throws IOException, URISyntaxException {
		if(java.awt.Desktop.isDesktopSupported() ) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
				java.net.URI uri = new java.net.URI("http://104.236.34.9:19327/static/");
				desktop.browse(uri);
			}
		} 
	}

	public static void poolInfoFTCWellen() throws IOException, URISyntaxException {
		if(java.awt.Desktop.isDesktopSupported() ) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
				java.net.URI uri = new java.net.URI("https://altminer.net/site/mining");
				desktop.browse(uri);
			}
		} 
	}

	public static void poolInfoFTCLizhi() throws IOException, URISyntaxException {
		if(java.awt.Desktop.isDesktopSupported() ) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
				java.net.URI uri = new java.net.URI("http://pool.ftc-c.com:19327/static/");
				desktop.browse(uri);
			}
		} 
	}

	public static void CoinCalcFTC() throws IOException, URISyntaxException {
		if(java.awt.Desktop.isDesktopSupported() ) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
				java.net.URI uri = new java.net.URI("https://whattomine.com");
				desktop.browse(uri);
			}
		} 
	}

	public static boolean checkURL(String website) throws IOException {

		try{
			final URLConnection connection = new URL(website).openConnection();
			connection.connect();
			return true;
		} catch(final IOException e){
			return false;
		}

	}

}




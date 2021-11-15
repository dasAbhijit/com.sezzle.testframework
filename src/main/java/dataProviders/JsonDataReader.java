package dataProviders;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Merchant;

public class JsonDataReader {
	private final String merchantFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Merchant.json";
	private List<Merchant> merchantList;
	
	public JsonDataReader(){
		merchantList = getMerchantData();
	}
	
	private List<Merchant> getMerchantData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(merchantFilePath));
			Merchant[] merchants = gson.fromJson(bufferReader, Merchant[].class);
			return Arrays.asList(merchants);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + merchantFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Merchant getMerchantByName(String merchantName){
		Merchant merchant = merchantList.stream().filter(x -> x.name.equalsIgnoreCase(merchantName)).findAny().get();
		return randomizeMerchantEmail(merchant);
	}

	private Merchant randomizeMerchantEmail(Merchant merchant) {
		merchant.email = merchant.name + new Random().nextInt(10000) + "@gamil.com";
		System.out.println(merchant.name);
		System.out.println(merchant.email);
		return merchant;
	}


}
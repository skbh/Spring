package nse.skbh.springboot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.logic.ReadURI;
import nse.skbh.springboot.pojo.Nse;
import nse.skbh.springboot.pojo.OIData;

@RestController
public class WebBoot {

	@RequestMapping("/oi")
	public OIData home() {
		String ftpUrl = "https://www.nseindia.com/archives/nsccl/mwpl/nseoi_27042018.zip";
		URL url = null;
		List<Nse> nse = null;
		try {
			url = new URL(ftpUrl);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			nse = ReadURI.unpackArchive(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OIData OIData = new OIData();
		OIData.setOpenInterest(nse);
		return OIData;
		//return new Gson().toJson(OIData);
	}
	
}

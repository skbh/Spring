package nse.skbh.springboot.logic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.Gson;

import nse.skbh.springboot.pojo.Nse;

public class ReadURI {

	private static void downloadUsingStream(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1) {
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}

	public static List<Nse> unpackArchive(URL url) throws IOException {

		String uri = "https://www.nseindia.com/archives/nsccl/mwpl/nseoi_27042018.zip";
		downloadUsingStream(uri, "nseoi_27042018.zip");
		URL obj = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		InputStream is = con.getInputStream();
		ZipInputStream zis = new ZipInputStream(is);
		ZipEntry entry;
		System.out.println(url.toString());
		File zipFile = new File("nseoi_27042018.zip");
		System.out.println(zipFile.getAbsoluteFile());
		@SuppressWarnings("resource")
		ZipFile zip = new ZipFile(zipFile);
		List<Nse> nse = new LinkedList<Nse>();
		while ((entry = zis.getNextEntry()) != null) {
			System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
			System.out.println(entry.getComment());
			BufferedReader bufferedeReader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
			String line = bufferedeReader.readLine();
			int i = 0;
			while (line != null) {
				if (i++ == 0) {
					line = bufferedeReader.readLine();
					continue;
				}
				Nse nseObj = new Nse();
				System.out.println(line);
				String[] a = line.split("\\,");
				nseObj.setDate(a[0]);
				nseObj.setISIN(a[1]);
				nseObj.setName(a[2]);
				nseObj.setScrip(a[3]);
				nseObj.setMWPL(a[4]);
				nseObj.setNSE_Open_Interest(a[5]);

				if ((i != 0)) {
					Float s = (Float.parseFloat(a[5]) / Float.parseFloat(a[4])) * 100;
					nseObj.setUsedLimit(s);
				} else {

				}
				// nseObj.setUsedLimit("UsedLimit");
				nse.add(nseObj);
				line = bufferedeReader.readLine();
			}
			bufferedeReader.close();
			break;
		}
		System.out.println(new Gson().toJson(nse));
		Collections.sort(nse, new CompratorClass());
		Collections.reverse(nse);
		System.out.println(nse);
		return nse;

	}

}
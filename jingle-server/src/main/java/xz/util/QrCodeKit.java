package xz.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2017/6/7 9:27.
 */
public class QrCodeKit {
	
	
	public static String createQrcode(String prefix, Long picName, String picDir) {
		String suffix = "png";
		HashMap<EncodeHintType, String> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		String fileName = picName + "." + suffix;
		File dir = new File(picDir);
		if(!dir.exists() && !dir.mkdirs())
			return "";
		Path path = Paths.get(picDir,fileName);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(prefix + picName, BarcodeFormat.QR_CODE, 360, 360, hints);
			MatrixToImageWriter.writeToPath(bitMatrix, suffix, path);
		} catch (IOException | WriterException e) {
			e.printStackTrace();
			return "";
		}
		return picName+"";
	}
	
	public void decode(String path) throws IOException, NotFoundException {
		LuminanceSource source = new BufferedImageLuminanceSource(ImageIO.read(new File(path)));
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
		Map<DecodeHintType, Object> hints = new HashMap<>();
		hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
		Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
		System.out.println("图片中内容：  ");
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		System.out.println(createQrcode("http://www.baidu.com", 0L, ""));
	}
}

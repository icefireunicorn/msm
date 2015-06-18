package stringutil;

import java.util.zip.CRC32;

public class UrlConvert {

	/**
	 * 图片URl地址转换成CDN地址
	 * @param  string $url url地址
	 * @return string
	 */
	public static String changeToCDNUrl(String url) {
		String path = url;
		long crc32Value = UrlConvert.getCrc32Value(path);
		int i = Math.abs(Long.valueOf(crc32Value).intValue()) % 6 + 1;
		System.out.println(i);
		System.out.println(crc32Value);
		return i+"";
	}
	private static long getCrc32Value(String path) {
		CRC32 crc32 = new CRC32();
		crc32.update(path.getBytes());
		return crc32.getValue();
	}
//	    if(C('changeCDNSrc')) {
//	        $img_src = parse_url($url);
//	        if(!isset($img_src['host']) || strpos($img_src['host'], 'kadang.com') !== false) {
//	            $i = abs(crc32($img_src['path'])) % 6 + 1;
//	            $url = 'http://img' . $i. '.i.kadang.cn' . $img_src['path'];
//	            $url .= isset($img_src['query']) ? '?' . $img_src['query'] : '';
//	        }
	public static void main(String[] args) {
		//http://img3.i.kadang.cn/static/mall/index/qixi/hot/hot_2_0728_2_3509.jpg
		//http://img4.i.kadang.cn/static/mall/index/qixi/hot/hot_3_0812_3_2601.jpg
		//http://img2.i.kadang.cn/upload/1/store/goods/43/2014/08/43_3364d509629a74e4d6ec384dc2fa55a4.jpg_small.jpg
		//http://img6.i.kadang.cn/upload/1/store/goods/6/2014/08/6_5000d016abfd7a835dbf9357ee7aeb66.jpg_small.jpg
		//http://img6.i.kadang.cn/upload/1/store/goods/43/2014/09/43_91f7967a215a87947a972c285d4ce76c.jpg_small.jpg
		String url ="/static/mall/index/qixi/hot/hot_2_0728_2_3509.jpg";
		UrlConvert.changeToCDNUrl(url);
		url ="/static/mall/index/qixi/hot/hot_3_0812_3_2601.jpg";
		UrlConvert.changeToCDNUrl(url);
		url ="/upload/1/store/goods/43/2014/08/43_3364d509629a74e4d6ec384dc2fa55a4.jpg_small.jpg";
		UrlConvert.changeToCDNUrl(url);
		url ="/upload/1/store/goods/6/2014/08/6_5000d016abfd7a835dbf9357ee7aeb66.jpg_small.jpg";
		UrlConvert.changeToCDNUrl(url);
		url ="/imgs/f/1/admin/140208/1321/vK6sOhx4PqbAT15LpQ1hx.jpg";
		UrlConvert.changeToCDNUrl(url);
		// TODO Auto-generated method stub

	}

}

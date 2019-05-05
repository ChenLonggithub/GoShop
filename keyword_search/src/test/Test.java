import java.util.List;

import jgsu.clong.FactoryUtil.MySqlSessionFactory;
import jgsu.clong.bean.KEYWORDS_T_MALL_SKU;
import jgsu.clong.bean.OBJECT_T_MALL_SKU;
import jgsu.clong.mapper.ClassMapper;
import jgsu.clong.util.MyPropertiesUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

public class Test {
	public static void main(String[] args) {
		SqlSessionFactory myF = MySqlSessionFactory.getSqlSessionFactory();
		ClassMapper mapper = myF.openSession().getMapper(ClassMapper.class);
		List<KEYWORDS_T_MALL_SKU> list_sku = mapper.select_list_by_flbh2(28);
		System.out.println(list_sku);
		// 想solr中导入sku数据

		/*导入sorl数据*/
		HttpSolrServer httpSolrServer = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties","solr_sku"));
		httpSolrServer.setParser(new XMLResponseParser());
		try{
			httpSolrServer.addBeans(list_sku);
			httpSolrServer.commit();
		}catch (Exception e){
			e.printStackTrace();
		}

		/*查询数据*/
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("sku_mch:小明");
		solrQuery.setRows(50);
		try {
			QueryResponse query = httpSolrServer.query(solrQuery);
			List<KEYWORDS_T_MALL_SKU> beans = query.getBeans(KEYWORDS_T_MALL_SKU.class);

			System.out.println(beans);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

}

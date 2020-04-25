import java.awt.Polygon;
import java.io.IOException;
import java.util.Hashtable;

import javax.lang.model.element.PackageElement;
import javax.swing.DefaultRowSorter;

public class DBAppTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DBApp dbApp = new DBApp();
		// dbApp.init();
		String strTableName = "student";
		Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
//		htblColNameType.put("id", "java.lang.Integer"); 
//		htblColNameType.put("name", "java.lang.String"); 
		htblColNameType.put("gpa", "java.lang.Double");
//		htblColNameType.put("pol", "java.awt.Polygon"); 
		try {
			dbApp.createTable( strTableName, "gpa", htblColNameType );
		} catch (DBAppException e) {
			e.getMessage();
		}
		try {
			dbApp.createBTreeIndex( strTableName, "gpa");
		} catch (DBAppException e) {
			e.getMessage();
		}
//		try {
//			dbApp.createRTreeIndex( strTableName, "pol");
//		} catch (DBAppException e) {
//			e.getMessage();
//		}
//		
		int[][] xpoints = { { 0, 1 }, { 2, 10 }, { 10, 100 } };
		int[][] ypoints = { { 0, 1 }, { 2, 10 }, { 10, 100 } };

		Double[] gpas = { 0.7, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9,
				3.0 };
		int[] ids = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		String[] names = { "hedaya", "akmal", "hedaya", "akmal", "hedaya", "akmal", "hedaya", "akmal", "hedaya",
				"akmal", "hedaya", "akmal", "hedaya", "akmal", "hedaya", "akmal", "hedaya", "akmal", "hedaya", "akmal",
				"hedaya", "akmal", "hedaya" };
		//for(int i = 0;i<10;i++) {
		int x = (int) (Math.random() * ((2 - 0) + 1));
		Hashtable<String, Object> htblColNameValue = new Hashtable<String, Object>();
		htblColNameValue.clear();
		Polygon pol = new Polygon(xpoints[2], ypoints[2], 2);
		htblColNameValue.put("gpa", 1.2);
//			htblColNameValue.put("name", names[x] );
//			htblColNameValue.put("gpa", gpas[x] );
//		try {
//			dbApp.insertIntoTable(strTableName, htblColNameValue);
//		} catch (DBAppException e) {
//			e.getMessage();
//		}


////
			try {
				dbApp.deleteFromTable(strTableName, htblColNameValue);
			} catch (DBAppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			BPTree tf = (BPTree) dbApp.deserialize(strTableName+ "gpa");
//			System.out.println(tf.search(1.2).size());
		//}

		Table t = (Table) dbApp.deserialize(strTableName);
		for (int i = 0; i < t.pageNames.size(); i++) {
			System.out.println(t.pageNames.get(i));
			Page p = (Page) dbApp.deserialize(t.pageNames.get(i));
			for (int j = 0; j < p.rows.size(); j++) {
				System.out.println(p.rows.get(j));
				// p.toString();
			}

		}
	}

}

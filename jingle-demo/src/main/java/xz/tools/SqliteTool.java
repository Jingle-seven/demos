package xz.tools;


import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SqliteTool {
	private static Connection conn;
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:mock.db");
			Statement stmt = conn.createStatement();
			String sql =
					"CREATE TABLE IF NOT EXISTS t_file" +
							"(filename	TEXT PRIMARY KEY	NOT NULL, " +
							"timestamp 		BIGINT 		NOT NULL," +
							" download			BOOLEAN	NOT NULL, " +
							" status			VARCHAR(20), " +
							" size				INT)";
			stmt.execute(sql);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Read history filename Failed. " + e);
		}
	}
	
	public static void insert(FileInfo fileInfo) {
		try {
			checkConnValid();
			PreparedStatement pst = conn.prepareStatement("INSERT INTO t_file VALUES(?,?,?,?,?)");
			setInsertPst(fileInfo, pst);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Insert file info error! " + e);
		}
	}
	
	
	public static void insert(Collection<FileInfo> fileInfos) {
		try {
			checkConnValid();
			conn.setAutoCommit(false);
			for (FileInfo fileInfo : fileInfos) {
				PreparedStatement pst = conn.prepareStatement("INSERT INTO t_file VALUES(?,?,?,?,?)");
				setInsertPst(fileInfo, pst);
				pst.execute();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("Insert file info error! " + e);
		}
	}
	public static void insertFileNames(Collection<String> fileNames) {
		try {
			checkConnValid();
			conn.setAutoCommit(false);
			for (String fileName : fileNames) {
				PreparedStatement pst = conn.prepareStatement("INSERT INTO t_file VALUES(?,?,?,?,?)");
				pst.setString(1, fileName);
				pst.setLong(2, System.currentTimeMillis());
				pst.setBoolean(3, true);
				pst.setString(4, "");
				pst.setInt(5,-1);
				pst.execute();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("Insert file info error! " + e);
		}
	}
	
	public static void deleteByFileName(String fileName) {
		try {
			checkConnValid();
			PreparedStatement pst = conn.prepareStatement("DELETE FROM t_file WHERE filename = ?");
			pst.setString(1, fileName);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Delete file info error! " + e);
		}
	}
	
	public static void deleteSomeByFileName(Collection<String> fileNames) {
		try {
			checkConnValid();
			conn.setAutoCommit(false);
			for (String fileName : fileNames) {
				PreparedStatement pst = conn.prepareStatement("DELETE FROM t_file WHERE filename = ?");
				pst.setString(1, fileName);
				pst.execute();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("Delete files info error! " + e);
		}
	}
	
	public static Set<String> findFileNames() {
		Set<String> filenames = new HashSet<>();
		try {
			checkConnValid();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT filename FROM t_file");
			while (rs.next()) {
				filenames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Query file info error! " + e);
		}
		return filenames;
	}
	
	public static Set<FileInfo> findFileInfos() {
		Set<FileInfo> fileInfos = new HashSet<>();
		try {
			checkConnValid();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM t_file");
			while (rs.next()) {
				FileInfo info = new FileInfo()
						.setFileName(rs.getString("filename"))
						.setTimeStamp(rs.getInt("timeStamp"))
						.setDownload(rs.getBoolean("download"))
						.setStatus(rs.getString("status"))
						.setSize(rs.getInt("size"));
				fileInfos.add(info);
			}
		} catch (SQLException e) {
			System.out.println("Query file info error! " + e);
		}
		return fileInfos;
	}
	
	public static FileInfo findFileByName(String fileName) {
		FileInfo info = new FileInfo();
		try {
			checkConnValid();
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM t_file WHERE filename=?");
			pst.setString(1, fileName);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				getFileInfoFromRs(info, rs);
			}
		} catch (SQLException e) {
			System.out.println("Query file info error! " + e);
		}
		return info;
	}
	
	
	
	public static void updateByFileName(FileInfo info) {
		try {
			checkConnValid();
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE t_file SET timestamp = ?,download = ?,status = ?,size = ? WHERE filename = ?");
			setUpdatePst(info, pst);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Update file info error! " + e);
		}
	}
	
	
	
	public static void updateByFileName(List<FileInfo> fileInfos) {
		try {
			checkConnValid();
			for(FileInfo info: fileInfos) {
				PreparedStatement pst = conn.prepareStatement(
						"UPDATE t_file SET timestamp = ?,download = ?,status = ?,size = ? WHERE filename = ?");
				setUpdatePst(info, pst);
				pst.execute();
			}
		} catch (SQLException e) {
			System.out.println("Update file info error! " + e);
		}
	}
	
	private static void checkConnValid() throws SQLException {
		if (!conn.isValid(0)) {
			conn = DriverManager.getConnection("jdbc:sqlite:mock.db");
		}
	}
	
	private static void setInsertPst(FileInfo fileInfo, PreparedStatement pst) throws SQLException {
		pst.setString(1, fileInfo.fileName);
		pst.setLong(2, fileInfo.timeStamp);
		pst.setBoolean(3, fileInfo.download);
		pst.setString(4, fileInfo.status);
		pst.setInt(5, fileInfo.size);
	}
	private static void setUpdatePst(FileInfo info, PreparedStatement pst) throws SQLException {
		pst.setLong(1, info.timeStamp);
		pst.setBoolean(2, info.download);
		pst.setString(3, info.status);
		pst.setLong(4, info.size);
		pst.setString(5, info.fileName);
	}
	private static void getFileInfoFromRs(FileInfo info, ResultSet rs) throws SQLException {
		info.setFileName(rs.getString("filename"));
		info.setTimeStamp(rs.getInt("timeStamp"));
		info.setDownload(rs.getBoolean("download"));
		info.setStatus(rs.getString("status"));
		info.setSize(rs.getInt("size"));
	}
	
	public static class FileInfo {
		public String fileName;
		public long timeStamp;
		public Boolean download;
		public String status;
		public int size;
		
		public FileInfo setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}
		
		public FileInfo setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}
		
		public FileInfo setDownload(Boolean download) {
			this.download = download;
			return this;
		}
		
		public FileInfo setStatus(String status) {
			this.status = status;
			return this;
		}
		
		public FileInfo setSize(int size) {
			this.size = size;
			return this;
		}
		
		@Override
		public String toString() {
			return "FileInfo{" +
					"timeStamp=" + timeStamp +
					", fileName='" + fileName + '\'' +
					", download=" + download +
					", status='" + status + '\'' +
					", size=" + size +
					'}';
		}
	}
}

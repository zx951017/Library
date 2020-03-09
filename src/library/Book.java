package library;

public class Book {
	//必要なフィールド　
		//book_id,
		//book_name,
		//book_author
		//book_price
		private int id;
		private String name;
		private String author;
		private String price;


		//コンストラクタ
		public Book(int id,String name,String author,String price) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			this.price = price;
		}
		public Book() {
			// TODO 自動生成されたコンストラクター・スタブ
		}
		public Book(String str) {
			// TODO 自動生成されたコンストラクター・スタブ
		}
		public String toString() {
			return id +"-"+ name +"-"+ author +"-"+ price;
		}



		//getter and setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}


		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}


		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
}


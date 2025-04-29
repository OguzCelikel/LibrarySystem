# **Bu Proje Hakkında**

Bu proje, **Tasarım Desenleri Yüksek Lisans** dersinin ödevi olarak hazırlanmıştır. 

---

## **Senaryo**

Bir kütüphane, kitap yönetimi ve kullanıcı ilişkilerini düzenlemek için bir otomasyon sistemi kullanmak istiyor. Kitapların ve kullanıcıların takip edilmesi, kitap ödünç verme ve iade süreçlerinin düzenlenmesi için aşağıdaki **tasarım desenleri** kullanılmıştır:

---

### **Kullanılan Tasarım Desenleri**

1. **Factory Method Pattern**  
   - **Açıklama**: Kütüphanedeki farklı türdeki kitapların (örneğin, tarih, bilim, roman) oluşturulması için kullanılmıştır.  
   - **Uygulama**: `BookFactory` sınıfı, `FictionBook`, `ScienceBook` ve `HistoryBook` gibi kitap türlerini üretmek için kullanılmıştır.  
   - **Kod Örneği**:
     ```java
     BookFactory fictionFactory = new BookFactory() {
         @Override
         public Book createBook(String title) {
             return new FictionBook(title);
         }
     };
     Book book1 = fictionFactory.createBook("The Great Gatsby");
     ```

2. **Singleton Pattern**  
   - **Açıklama**: Kütüphane sistemi, sistemdeki veri bütünlüğünü sağlamak için tek bir `LibrarySystem` sınıfı örneği kullanmaktadır.  
   - **Uygulama**: `LibrarySystem` sınıfı, tüm kitap ve kullanıcı işlemlerini merkezi bir şekilde yönetmektedir.  
   - **Kod Örneği**:
     ```java
     LibrarySystem library = LibrarySystem.getInstance();
     library.addBook("The Catcher in the Rye");
     ```

3. **Observer Pattern**  
   - **Açıklama**: Kitapların durum değişikliklerini (örneğin, ödünç alınması veya iadesi) takip etmek için kullanılmıştır.  
   - **Uygulama**: `Book` sınıfı gözlemlenebilir (`Observable`) hale getirilmiş ve `User` sınıfı gözlemci (`Observer`) olarak tanımlanmıştır. Kitap durum değişikliklerinde kullanıcılar bilgilendirilmiştir.  
   - **Kod Örneği**:
     ```java
     book1.addObserver(user1);
     book1.setAvailable(false); // Kullanıcılar bilgilendirilir
     ```

4. **Chain of Responsibility Pattern**  
   - **Açıklama**: Kitap ödünç verme sürecinde birden fazla kontrol mekanizması (örneğin, stok kontrolü, kullanıcı limit kontrolü) oluşturmak için kullanılmıştır.  
   - **Uygulama**: `StockHandler`, `UserLimitHandler` ve `NotificationHandler` sınıfları bir zincir oluşturmuş ve sırasıyla işlemleri gerçekleştirmiştir.  
   - **Kod Örneği**:
     ```java
     Handler stockHandler = new StockHandler();
     Handler userLimitHandler = new UserLimitHandler();
     stockHandler.setNext(userLimitHandler).setNext(notificationHandler);
     stockHandler.handle(book1, user1);
     ```

5. **Mediator Pattern**  
   - **Açıklama**: Kitap ödünç verme ve iade süreçlerinde kullanıcılar ve kitaplar arasındaki iletişimi yönetmek için kullanılmıştır.  
   - **Uygulama**: `LibraryMediatorImpl` sınıfı, kitap ve kullanıcı işlemlerini koordine etmiştir.  
   - **Kod Örneği**:
     ```java
     LibraryMediator mediator = new LibraryMediatorImpl();
     mediator.borrowBook(book1, user1);
     mediator.returnBook(book1, user1);
     ```

---

## **Kullanılan Teknolojiler**

- **Java (Version 17)**
- **IntelliJ IDEA 2021.2.3**
- **Git**

---

## **Önkoşullar**

Projenin çalıştırılması için bilgisayarınızda Java'nın kurulu olması gereklidir.

---

## **Kurulum**

1. Repoyu klonlayın:
   ```bash
   git clone https://github.com/OguzCelikel/Library_Management_System.git
   ```
2. Klonladığınız projede `Main.java` dosyasını açın ve projeyi çalıştırın.



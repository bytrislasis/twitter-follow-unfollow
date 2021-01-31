
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;

public class Selenium {

    public static WebDriver driver;
    private List<WebElement> searchBoxtakip;

    public void loginTwitter() throws InterruptedException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String path = s + System.getProperty("file.separator") + "driver" + System.getProperty("file.separator");

        int ChromeVersion = TwitterApp.jComboBox3.getSelectedIndex();

        if (ChromeVersion == 0) {
            System.setProperty("webdriver.chrome.driver", path + "dryazilim.com.exe");
        }

    

        Object show = TwitterApp.jComboBox2.getSelectedItem();

        try {
            if (show == "Hide") {
                this.driver = new ChromeDriver(HideChrome());
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                this.driver = new ChromeDriver(options);
            }
            TwitterApp.log.append("Tarayıcı Açıldı\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Chrome Versiyonu Doğru Seçtiğinize Emin Olun." + path, "Versiyon Hatası", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.driver.get("https://twitter.com/login");
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement searchBox = this.driver.findElement(By.name("session[username_or_email]"));
        searchBox.sendKeys(TwitterApp.jTextField1.getText());
        Thread.sleep(2000);
        WebElement searchBox1 = this.driver.findElement(By.name("session[password]"));
        searchBox1.sendKeys(String.valueOf(TwitterApp.jTextField2.getText()));
        searchBox.submit();
        TwitterApp.log.append("Twittera Giriş Yapıldı\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());

        Thread.sleep(2000);

    }

    public void TrendTopicFollow(String kelime) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='']")).sendKeys("#" + kelime);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='#" + kelime + "']")).sendKeys(Keys.ENTER);
        TwitterApp.log.append("Trend Kelimesi Gönderildi\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div/div[2]/nav/div[2]/div[3]/a")).click();
        TwitterApp.log.append("Kişiler Aranıyor\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        try {
            for (int is = 0; is < 10; is++) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(1000);
            }

            js.executeScript("window.scrollTo(0, 0)");
        } catch (InterruptedException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e, "Hata Raporu Gönderildi", JOptionPane.ERROR_MESSAGE);
        }

        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        Object lang = TwitterApp.jComboBox1.getSelectedItem();
        if (lang == "TR") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Takip et']"));
        }

        if (lang == "EN") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Follow']"));
        }

        if (lang == "DE") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Folgen']"));
        }
        for (WebElement buttons : searchBoxtakip) {
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));
            buttons.click();
            TwitterApp.log.append("Takip Etme Başarılı\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }

        TrendTopicFollow(kelime);
        this.driver.quit();
    }

    public void SearchFollow(String kelime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='']")).sendKeys("" + kelime);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='" + kelime + "']")).sendKeys(Keys.ENTER);
        TwitterApp.log.append("Arama Kelimesi Gönderildi\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div/div[2]/nav/div[2]/div[3]/a")).click();
        TwitterApp.log.append("Kişiler Aranıyor\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        try {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, 0)");
        } catch (InterruptedException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e, "Versiyon Hatası", JOptionPane.ERROR_MESSAGE);
        }

        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        String winHandleBefore = driver.getWindowHandle();
        this.driver.getWindowHandles().forEach((winHandle) -> {
            this.driver.switchTo().window(winHandle);
        });

        Object lang = TwitterApp.jComboBox1.getSelectedItem();
        if (lang == "TR") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Takip et']"));
        }

        if (lang == "EN") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Follow']"));
        }

        if (lang == "DE") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Folgen']"));
        }
        for (WebElement buttons : searchBoxtakip) {
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));
            buttons.click();
            TwitterApp.log.append("Takip Etme Başarılı\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }

        SearchFollow(kelime);
        this.driver.quit();
    }

    public void UnFollow(String username) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String winHandleBefore = driver.getWindowHandle();
        this.driver.getWindowHandles().forEach((winHandle) -> {
            this.driver.switchTo().window(winHandle);
        });
        this.driver.navigate().to("https://twitter.com/" + URLEncoder.encode(username) + "/following");
        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));
        Object lang = TwitterApp.jComboBox1.getSelectedItem();

        try {
            for (int is = 0; is < 10; is++) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(1000);
            }

            js.executeScript("window.scrollTo(0, 0)");
        } catch (InterruptedException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e, "Hata Raporu Gönderildi -1", JOptionPane.ERROR_MESSAGE);
        }

        if (lang == "TR") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Takip ediliyor']"));
        }

        if (lang == "EN") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Following']"));
        }

        if (lang == "DE") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Folge ich']"));
        }

        for (WebElement buttons : this.searchBoxtakip) {
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttons);
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

            WebElement userName = driver.switchTo().activeElement();
            userName.sendKeys(Keys.ENTER);
            TwitterApp.log.append("Takip Etme Bırakıldı\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }

        UnFollow(username);
        this.driver.quit();
    }

    public void userFollowLogin(String username) throws InterruptedException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String path = s + System.getProperty("file.separator") + "driver" + System.getProperty("file.separator");

        int ChromeVersion = TwitterApp.jComboBox3.getSelectedIndex();

        if (ChromeVersion == 0) {
            System.setProperty("webdriver.chrome.driver", path + "81.exe");
        }

        if (ChromeVersion == 1) {
            System.setProperty("webdriver.chrome.driver", path + "80.exe");
        }

        if (ChromeVersion == 2) {
            System.setProperty("webdriver.chrome.driver", path + "79.exe");
        }

        Object show = TwitterApp.jComboBox2.getSelectedItem();

        try {
            if (show == "Hide") {
                this.driver = new ChromeDriver(HideChrome());
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                this.driver = new ChromeDriver(options);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Chrome Versiyonu Doğru Seçtiğinize Emin Olun." + path, "Versiyon Hatası", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.driver.get("https://twitter.com/login/error?username_or_email=&redirect_after_login=https://twitter.com/" + username + "/followers");
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement searchBox = this.driver.findElement(By.name("session[username_or_email]"));
        searchBox.sendKeys(TwitterApp.jTextField1.getText());
        Thread.sleep(2000);
        WebElement searchBox1 = this.driver.findElement(By.name("session[password]"));
        searchBox1.sendKeys(TwitterApp.jTextField2.getText());
        searchBox.submit();
        TwitterApp.log.append("Twittera Giriş Yapıldı\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        Thread.sleep(2000);
        userFollow();
    }

    public void userFollow() throws InterruptedException {
        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        Object lang = TwitterApp.jComboBox1.getSelectedItem();

        ArrayList<WebElement> list = null;

        if (lang == "TR") {
            this.searchBoxtakip = list = new ArrayList<>(driver.findElements(By.xpath("//span[text() = 'Takip et']")));
        }

        if (lang == "EN") {
            this.searchBoxtakip = list = new ArrayList<>(driver.findElements(By.xpath("//span[text() = 'Follow']")));
        }

        if (lang == "DE") {
            this.searchBoxtakip = list = new ArrayList<>(driver.findElements(By.xpath("//span[text() = 'Folgen']")));
        }

        TwitterApp.log.append("Yeni Kişiye Geçildi Bulunan Kişi Sayısı " + list.size() + "\n");
        TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());

        for (WebElement buttons : this.searchBoxtakip) {
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));
            try {
                buttons.click();
                TwitterApp.log.append("Takip Etme Başarılı\n");
                TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
            } catch (Exception e) {
                TwitterApp.log.append("Takip Et Butonuna Tıklayamadı\n");
                TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
            }
        }
        Random rand = new Random();
        int bulunan;
        if (list.size() == 0) {
            bulunan = 1;
        } else {
            bulunan = rand.nextInt(list.size());
        }

        Thread.sleep(2000);
        try {
            this.driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/section/div/div/div/div[" + bulunan + "]/div/div/div/div[2]/div/div/a/div/div/div/span/span")).click();
        } catch (Exception e) {
            TwitterApp.log.append("Bir Hata Oluştu Yinede Devam Ediyor\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        } finally {
            try {
                this.driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/section/div/div/div/div[1]/div/div/div/div[2]/div/div/a/div/div/div/span/span")).click();
            } catch (Exception e) {
                TwitterApp.log.append("Hata oluştu devam ediyor\n");
                TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
            }
        }
        Thread.sleep(5000);
        try {
            this.driver.findElement(By.xpath("//span[text() = 'Takipçi']")).click();
        } catch (Exception e) {
            TwitterApp.log.append("Lütfen tekrar başka bir kullanıcı ile deneyin\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }
        Thread.sleep(2000);
        list.clear();
        userFollow();

        this.driver.quit();

    }

    public void FollowIsFollow() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/header/div/div/div/div/div[2]/nav/a[7]/div/div[2]/span")).click();

        } catch (Exception e) {
            TwitterApp.log.append("Bir hata oluştu -1\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div/div/div[5]/div[2]/a/span[2]/span")).click();
        } catch (Exception e) {
            TwitterApp.log.append("Bir hata oluştu -2\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }

        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        try {
            for (int ii = 0; ii < 10; ii++) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(1000);
            }
            js.executeScript("window.scrollTo(0, 0)");
        } catch (InterruptedException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e, "Versiyon Hatası", JOptionPane.ERROR_MESSAGE);
        }

        Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));

        String winHandleBefore = driver.getWindowHandle();
        this.driver.getWindowHandles().forEach((winHandle) -> {
            this.driver.switchTo().window(winHandle);
        });

        Object lang = TwitterApp.jComboBox1.getSelectedItem();
        if (lang == "TR") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Takip et']"));
        }

        if (lang == "EN") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Follow']"));
        }

        if (lang == "DE") {
            this.searchBoxtakip = this.driver.findElements(By.xpath("//span[text() = 'Folgen']"));
        }
        for (WebElement buttons : searchBoxtakip) {
            Thread.sleep((getRandomNumberInRange(1, Integer.parseInt(TwitterApp.jTextField5.getText())) * 1000));
            buttons.click();

            TwitterApp.log.append(buttons.getText() + " İsimli Kişi Takip Edildi.\n");
            TwitterApp.log.setCaretPosition(TwitterApp.log.getDocument().getLength());
        }

        FollowIsFollow();
        this.driver.quit();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

  
    public ChromeOptions HideChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        return options;
    }
}

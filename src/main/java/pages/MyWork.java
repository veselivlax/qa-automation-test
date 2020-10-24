package pages;



public class MyWork extends BasePage {

    private HomePage homePage;
    private RegistrujteSePage registrujteSePage;
    private UlogujteSePage ulogujteSePage;
    private PdpPage pdpPage;
    private OglasiKojePratimPage oglasiKojePratimPage;
    private OcenitePage ocenitePage;


    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;

    }

    public RegistrujteSePage registrujteSePage() {
        if (registrujteSePage == null) {
            registrujteSePage = new RegistrujteSePage();
        }
        return registrujteSePage;
    }

    public UlogujteSePage ulogujteSePage() {
        if (ulogujteSePage == null) {
            ulogujteSePage = new UlogujteSePage();
        }
        return ulogujteSePage;

    }

    public PdpPage pdpPage() {
        if (pdpPage == null) {
            pdpPage = new PdpPage();
        }
        return pdpPage;
    }

    public OglasiKojePratimPage oglasiKojePratimPage() {
        if (oglasiKojePratimPage == null) {
            oglasiKojePratimPage = new OglasiKojePratimPage();
        }
        return oglasiKojePratimPage;
    }

    public OcenitePage ocenitePage() {
        if (ocenitePage == null) {
            ocenitePage = new OcenitePage();
        }
        return ocenitePage;
    }
}

package pageobject.pms.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class KontrakKerjaSamaPO {
    private Page page;

    //Profil Pemilik
    Locator kontrakKerjaSamaTab;
    Locator sectionOwnerProfile;
    Locator namaPemilik;
    Locator nomorHPPemilik;
    Locator alamatPemilik;
    Locator provinsiPemilik;
    Locator kotaPemilik;
    Locator kecamatanPemilik;
    Locator kelurahanPemilik;
    Locator ubahProfilPemilikButton;
    //End Profil Pemilik

    public KontrakKerjaSamaPO (Page page){
        this.page = page;

        kontrakKerjaSamaTab = page.locator("[aria-controls='contract']");
        sectionOwnerProfile = page.locator("#owner-profile");
        namaPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(0);
        nomorHPPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(1);
        alamatPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(2);
        provinsiPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(3);
        kotaPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(4);
        kecamatanPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(5);
        kelurahanPemilik = page.locator("#owner-profile .bg-c-list-item__description").nth(6);
        ubahProfilPemilikButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Ubah")).first();
    }

}

package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Friends extends BasePage {

    //Once in the profile, go to see all friends
    @FindBy(css = "div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.cbu4d94t.g5gj957u.d2edcug0.hpfvmrgz.rj1gh0hx.buofh1pr:nth-child(1) h2.gmql0nx0.l94mrbxd.p1ri9a11.lzcic4wl.d2edcug0.hpfvmrgz span.d2edcug0.hpfvmrgz.qv66sw1b.c1et5uql.lr9zc1uh.o3w64lxj.b2s5l15y.hnhda86s.oo9gr5id span.a8c37x1j.ni8dbmo4.stjgntxs.l9j0dhe7.r8blr3vg > a.oajrlxb2.g5ia77u1.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz.rq0escxv.nhd2j8a9.nc684nl6.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.jb3vyjys.rz4wbd8a.qt6c0cv9.a8nywdso.i1ao9s8h.esuyzwwr.f1sip0of.lzcic4wl.gmql0nx0.gpro0wi8.hnhda86s")
    private WebElement friendList;

    //Selecting a specific friend
    @FindBy(css = "div.bp9cbjyn.ue3kfks5.pw54ja7n.uo3d90p7.l82x9zwi.n1f8r23x.rq0escxv.j83agx80.bi6gxh9e.discj3wi.hv4rvrfc.ihqw7lf3.dati1w0a.gfomwglr:nth-child(3) div.buofh1pr.hv4rvrfc:nth-child(2) div:nth-child(1) a.oajrlxb2.g5ia77u1.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz.rq0escxv.nhd2j8a9.nc684nl6.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.jb3vyjys.rz4wbd8a.qt6c0cv9.a8nywdso.i1ao9s8h.esuyzwwr.f1sip0of.lzcic4wl.gmql0nx0.gpro0wi8 > span.d2edcug0.hpfvmrgz.qv66sw1b.c1et5uql.lr9zc1uh.a8c37x1j.keod5gw0.nxhoafnm.aigsh9s9.d3f4x2em.fe6kdd0r.mau55g9w.c8b282yb.mdeji52x.a5q79mjw.g1cxx5fr.lrazzd5p.oo9gr5id")
    private WebElement selectingAFriend;

    //Sending a message to a friend
    @FindBy(css = "div[class=\"cgat1ltu kkf49tns g5gj957u r2nqfv2r jgsskzai\"]")
    private WebElement prepareAMessage;



    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public Friends(WebDriver pDriver) {
        super(pDriver);
    }


}

package com.epam.core.dao;

import com.epam.core.entity.GiftCertificate;

import java.util.List;

public interface GiftRepository {

    List<GiftCertificate> getAllGiftCertificates();

    GiftCertificate getGiftCertificateById(Long id);

    int saveGiftCertificate(GiftCertificate giftCertificate);

    int updateGiftCertificate(GiftCertificate giftCertificate);

    int deleteGiftCertificate(Long id);

    List<GiftCertificate> getGiftCertificateByTagName(String tagName);

    List<GiftCertificate> getGifrcertificateByPartOfName(String name);

    List<GiftCertificate> getGiftCertificatesByDateAscending();

}

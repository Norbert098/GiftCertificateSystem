package com.epam.core.impldao;

import com.epam.core.dao.GiftRepository;
import com.epam.core.entity.GiftCertificate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GiftRepositoryImpl implements GiftRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_CERTIFICATES = "select * from gift_certificate";
    private static final String GET_BY_ID = "select * from gift_certificate where id = ?";
    private static final String ADD= "insert into gift_certificate (name, description, price, duration, " +
            "create_date, last_update_date)values (?,?,?,?,?,?)";
    private static final String UPDATE = "update gift_certificate set name=?, description=?, price=?," +
            " duration=? where id=?";
    private static final String DELETE = "delete from gift_certificate where id=";
    private static final String GET_BY_TAG_NAME = "select gift_certificate.id, gift_certificate.name, " +
            "gift_certificate.description, gift_certificate.price, gift_certificate.duration, " +
            "gift_certificate.create_date, " +
            "gift_certificate.last_update_date from tag INNER JOIN " +
            "(gift_certificate INNER JOIN gift_certificate_tag ON gift_certificate.id " +
            "= gift_certificate_tag.gift_certificate_id) ON tag.id = gift_certificate_tag.tag_id where tag.name=?";
    private static final String GET_BY_PARTOFNAME = "select * from gift_certificate where name like ?";
    private static final String GET_BY_ASC = "select * from gift_certificate where name like ?";

    @Override
    public List<GiftCertificate> getAllGiftCertificates() {
        return jdbcTemplate.query(GET_ALL_CERTIFICATES, new GiftCertificateMapper());
    }

    @Override
    public GiftCertificate getGiftCertificateById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, new GiftCertificateMapper(), id);
    }

    @Override
    public int saveGiftCertificate(GiftCertificate giftCertificate) {
        return jdbcTemplate.update(ADD);
    }

    @Override
    public int updateGiftCertificate(GiftCertificate giftCertificate) {
        return jdbcTemplate.update(UPDATE, giftCertificate.getName());
    }

    @Override
    public int deleteGiftCertificate(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<GiftCertificate> getGiftCertificateByTagName(String tagName) {
        return jdbcTemplate.query(GET_BY_TAG_NAME, new GiftCertificateMapper(), tagName);
    }

    @Override
    public List<GiftCertificate> getGifrcertificateByPartOfName(String name) {
        return jdbcTemplate.query(GET_BY_PARTOFNAME, new GiftCertificateMapper(), name);
    }

    @Override
    public List<GiftCertificate> getGiftCertificatesByDateAscending() {
        return jdbcTemplate.query(GET_BY_ASC, new GiftCertificateMapper());
    }
}

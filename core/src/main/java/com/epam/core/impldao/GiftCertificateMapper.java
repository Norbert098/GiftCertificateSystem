package com.epam.core.impldao;

import com.epam.core.entity.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class GiftCertificateMapper implements RowMapper<GiftCertificate> {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PRICE = "PRICE";
    private static final String DURATION = "DURATION";
    private static final String CREATE_DATE = "CREATE_DATE";


    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GiftCertificate(rs.getLong(ID),
                rs.getString(NAME),
                rs.getString(DESCRIPTION),
                rs.getDouble(PRICE),
                rs.getInt(DURATION),
                rs.getDate(CREATE_DATE) != null ? simpleDateFormat.format(rs.getDate(CREATE_DATE)) : null,
                rs.getDate("LAST_UPDATE_DATE") != null ? simpleDateFormat.format(rs.getDate("LAST_UPDATE_DATE")) : null,
                null);
    }
}
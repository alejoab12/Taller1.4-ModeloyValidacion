package com.bank.abc.BankABCTransform.utilities;

public interface Util {
    public final static String XSL_REMOVE_NAMESPACES="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
            "<xsl:stylesheet version=\"1.0\"\r\n" +
            "    xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n" +
            "    <xsl:output method=\"xml\" indent=\"yes\" />\r\n" +
            "\r\n" +
            "    <xsl:template match=\"*\">\r\n" +
            "        <xsl:element name=\"{local-name(.)}\">\r\n" +
            "            <xsl:apply-templates select=\"@* | node()\" />\r\n" +
            "        </xsl:element>\r\n" +
            "    </xsl:template>\r\n" +
            "    <xsl:template match=\"@*\">\r\n" +
            "        <xsl:attribute name=\"{local-name(.)}\">\r\n" +
            "      <xsl:value-of select=\".\" />\r\n" +
            "    </xsl:attribute>\r\n" +
            "    </xsl:template>\r\n" +
            "</xsl:stylesheet>";
}

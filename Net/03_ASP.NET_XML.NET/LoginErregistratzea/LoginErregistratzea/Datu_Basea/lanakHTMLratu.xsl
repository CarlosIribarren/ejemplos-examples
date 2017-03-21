<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html"/>

  <xsl:template match="lanGenerikoak">
    <html>
      <h3>Hautatutako irakasgaiko lan generikoak</h3>
      <body>
        <table border="2">
          <tr>
            <th>KODEA</th>
            <th>DESKRIBAPENA</th>
            <th>AURREIK. ORDUAK</th>
          </tr>
          <xsl:for-each select="lana">
            <xsl:sort select="aurreikusitakoOrduak" data-type="number"/>
            <tr>
              <td>
                <xsl:value-of select="kodea"/>
              </td>
              <td>
                <xsl:value-of select="deskribapena"/>
              </td>
              <td>
                <xsl:value-of select="aurreikusitakoOrduak"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>


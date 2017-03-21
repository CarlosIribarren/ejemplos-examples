<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    
    
    <xsl:template match="/TEI.2/text/body/entry">
        
        <xsl:for-each select="def">
            <def>
                1. <xsl:value-of select="text()"/>
            </def>
        </xsl:for-each>

        <xsl:for-each select="sense/def">
            <sensedef>
                <xsl:value-of select="../@n"/>
                 .<xsl:value-of select="text()"/>
            </sensedef>
        </xsl:for-each>
        
        
        
    </xsl:template>


    
</xsl:stylesheet>
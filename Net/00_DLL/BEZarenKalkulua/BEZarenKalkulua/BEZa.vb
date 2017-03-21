Public Class BEZa

    Public Function Kalkulua(ByVal zenbakia As Double, ByVal mota As String) As Emaitza

        Dim aplikatutakoBez As Double
        Dim gureEmaitza As New Emaitza

        Select Case mota
            Case "orokorra"
                aplikatutakoBez = 0.21
            Case "murriztua"
                aplikatutakoBez = 0.1
            Case "oinarrizkoa"
                aplikatutakoBez = 0.04
                'defeztuz
            Case Else
                aplikatutakoBez = 0.21
        End Select

        gureEmaitza.eman_BEZarekin(zenbakia * aplikatutakoBez)
        gureEmaitza.eman_BEZgabe(zenbakia - gureEmaitza.lortu_BEZarekin)

        Return gureEmaitza

    End Function


End Class

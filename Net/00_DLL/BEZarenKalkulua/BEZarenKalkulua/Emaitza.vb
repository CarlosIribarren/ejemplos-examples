Public Class Emaitza

    Private BEZarekin As Double
    Private BEZgabe As Double


    Public Sub eman_BEZarekin(ByVal balioa As Double)
        BEZarekin = balioa
    End Sub
    Public Function lortu_BEZarekin()
        Return BEZarekin
    End Function
    '---------------------------------------------------
    Public Sub eman_BEZgabe(ByVal balioa As Double)
        BEZgabe = balioa
    End Sub
    Public Function lortu_BEZgabe()
        Return BEZgabe
    End Function

End Class

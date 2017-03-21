Module ProbatuDatuAtzipenak

    Public Sub probatuIkasleaLortu()
        Console.Clear()
        Console.WriteLine("------------- IKASLEA LORTU PROBA ------------------------")
        Console.WriteLine(" ")
        Console.WriteLine("Idatzi ikasle baten email-a : ")
        Dim email As String = Console.ReadLine

        Dim gure_ikasle As New DBKudeatzailea.Ikaslea

        Try
            gure_ikasle = DBKudeatzailea.DatuAtzipena.IkasleaLortu(email)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            Console.WriteLine("ezin da ikaslea lortu" + ex.Message)
        End Try
        Console.WriteLine(" ")
        Console.WriteLine("-------- ERANTZUNA --------------- ")
        Console.WriteLine("Email :" & gure_ikasle.email_helbidea)
        Console.WriteLine("Izena :" & gure_ikasle.izena)
        Console.WriteLine("Abizena :" & gure_ikasle.abizena)
        Console.WriteLine("Pasahitza :" & gure_ikasle.pasahitza)
        Console.WriteLine("Galdera ezkutua :" & gure_ikasle.galdera_ezkutua)
        Console.WriteLine("Galdera ezkutuaren erantzuna :" & gure_ikasle.galdera_ezkutuaren_erantzunak)
        Console.WriteLine("Egiaztatzen zenbakia :" & gure_ikasle.egiaztatze_zenbakia)
        Console.WriteLine("Egiaztatua :" & gure_ikasle.egiaztatua)

        Console.WriteLine(" ")
        Console.WriteLine("Botoi bat sakatu menu nagusira joateko ")
        Console.ReadLine()
        Console.Clear()


    End Sub

    Public Sub probaEgiaztatu()

        Console.Clear()
        Console.WriteLine("------------- IKASLEA EGIAZTATU PROBA ------------------------")
        Console.WriteLine(" ")
        Console.WriteLine("Idatzi ikasle baten email-a : ")
        Dim email As String = Console.ReadLine

        Try
            DBKudeatzailea.DatuAtzipena.ikasleaEgiaztatu(email)
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaikasleaEgiaztatu
            Console.WriteLine("ez da ikaslea egiaztatu" + ex.Message)
        End Try

        Dim gure_ikasle As New DBKudeatzailea.Ikaslea
        Try
            gure_ikasle = DBKudeatzailea.DatuAtzipena.IkasleaLortu(email)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            Console.WriteLine("ezin da ikaslea lortu" + ex.Message)
        End Try

        Console.WriteLine(" ")
        Console.WriteLine("-------- ERANTZUNA --------------- ")
        Console.WriteLine("Email :" & gure_ikasle.email_helbidea)
        Console.WriteLine("Izena :" & gure_ikasle.izena)
        Console.WriteLine("Abizena :" & gure_ikasle.abizena)
        Console.WriteLine("Pasahitza :" & gure_ikasle.pasahitza)
        Console.WriteLine("Galdera ezkutua :" & gure_ikasle.galdera_ezkutua)
        Console.WriteLine("Galdera ezkutuaren erantzuna :" & gure_ikasle.galdera_ezkutuaren_erantzunak)
        Console.WriteLine("Egiaztatzen zenbakia :" & gure_ikasle.egiaztatze_zenbakia)
        Console.WriteLine("Egiaztatua :" & gure_ikasle.egiaztatua)

        Console.WriteLine(" ")
        Console.WriteLine("Botoi bat sakatu menu nagusira joateko ")
        Console.ReadLine()
        Console.Clear()

    End Sub

    Public Sub probaIkaslearenPasahitzaAldatu()
        Console.Clear()
        Console.WriteLine("------------- IKASLEAREN PASAHITZA ALDATU PROBA ------------------------")
        Console.WriteLine(" ")
        Console.WriteLine("Idatzi ikasle baten email-a : ")
        Dim email As String = Console.ReadLine
        Console.WriteLine("Idatzi pasahitz berria : ")
        Dim pasahitza As String = Console.ReadLine
        Try
            DBKudeatzailea.DatuAtzipena.ikaslearenPasahitzaAldatu(email, pasahitza)
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaikaslearenPasahitzaAldatu
            Console.WriteLine("ez da ikaslearen pasahitza aldatu" + ex.Message)
        End Try

        Dim gure_ikasle As New DBKudeatzailea.Ikaslea
        Try
            gure_ikasle = DBKudeatzailea.DatuAtzipena.IkasleaLortu(email)

        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaIkasleaLortu
            Console.WriteLine("ezin da ikaslea lortu" + ex.Message)
        End Try

        Console.WriteLine(" ")
        Console.WriteLine("-------- ERANTZUNA --------------- ")
        Console.WriteLine("Email :" & gure_ikasle.email_helbidea)
        Console.WriteLine("Izena :" & gure_ikasle.izena)
        Console.WriteLine("Abizena :" & gure_ikasle.abizena)
        Console.WriteLine("Pasahitza :" & gure_ikasle.pasahitza)
        Console.WriteLine("Galdera ezkutua :" & gure_ikasle.galdera_ezkutua)
        Console.WriteLine("Galdera ezkutuaren erantzuna :" & gure_ikasle.galdera_ezkutuaren_erantzunak)
        Console.WriteLine("Egiaztatzen zenbakia :" & gure_ikasle.egiaztatze_zenbakia)
        Console.WriteLine("Egiaztatua :" & gure_ikasle.egiaztatua)

        Console.WriteLine(" ")
        Console.WriteLine("Botoi bat sakatu menu nagusira joateko ")
        Console.ReadLine()
        Console.Clear()

    End Sub

    Public Sub probaIkasleaTxertatu()
        Console.Clear()
        Console.WriteLine("------------- IKASLEA TXERTATU PROBA ------------------------")
        Console.WriteLine(" ")
        Console.WriteLine("Idatzi email-a : ")
        Dim email As String = Console.ReadLine
        Console.WriteLine("Idatzi izena : ")
        Dim izena As String = Console.ReadLine
        Console.WriteLine("Idatzi abizena : ")
        Dim abizena As String = Console.ReadLine
        Console.WriteLine("Idatzi pasahitza : ")
        Dim pasahitza As String = Console.ReadLine
        Console.WriteLine("Idatzi galdera ezkutua : ")
        Dim galderaEzkutua As String = Console.ReadLine
        Console.WriteLine("Idatzi galdera ezkutuaren erantzuna : ")
        Dim galderaEzkutuarenErantzuna As String = Console.ReadLine
        Console.WriteLine("Idatzi egiaztatze zenbakia : ")
        Dim egiaztatzenZenbakia As Integer = Console.ReadLine
        Console.WriteLine("Idatzi egiaztatua(True edo False) : ")
        Dim egiaztatua As Boolean = Console.ReadLine

        Dim ikasleBerria As New DBKudeatzailea.Ikaslea

        ikasleBerria.email_helbidea = email
        ikasleBerria.izena = izena
        ikasleBerria.abizena = abizena
        ikasleBerria.pasahitza = pasahitza
        ikasleBerria.galdera_ezkutua = galderaEzkutua
        ikasleBerria.galdera_ezkutuaren_erantzunak = galderaEzkutuarenErantzuna
        ikasleBerria.egiaztatze_zenbakia = egiaztatzenZenbakia
        ikasleBerria.egiaztatua = egiaztatua

        Dim erregistroZenb As Integer
        Try
            erregistroZenb = DBKudeatzailea.DatuAtzipena.IkasleaTxertatu(ikasleBerria)
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaTxertatzean
            Console.WriteLine("Ezin da ikaslea txertatu" + ex.Message)
        End Try


        Console.WriteLine("Datu basean  " & erregistroZenb & " erregistro gehitu dira ")
        Console.WriteLine(" ")
        Console.WriteLine("Botoi bat sakatu menu nagusira joateko ")
        Console.ReadLine()
        Console.Clear()

    End Sub


    Sub Main()
        '-----------------KONEXIOA-------------------------
        Try
            DBKudeatzailea.DatuAtzipena.Konektatu("C:\db\Ikasleak.mdb")
        Catch ex As DBKudeatzailea.DatuAtzipena.ErroreaKonektatzean
            Console.WriteLine("ezin da konektatu" & ex.Message)
        End Try
        '------------------------------------------------------------

        Dim aukera As Integer
        aukera = 0


        While Not (aukera = 5)
            Console.WriteLine("-----------MENUA-------------")
            Console.WriteLine("1.- Ikaslea Lortu : ")
            Console.WriteLine("2.- Ikaslea Txertatu : ")
            Console.WriteLine("3.- Ikaslea Egiaztatu : ")
            Console.WriteLine("4.- Ikaslearen Pasahitza aldatu :")
            Console.WriteLine("5.- Atera :")
            Console.WriteLine(" ")
            Console.WriteLine(" Aukeratau zenbaki bat : ")
            aukera = Console.ReadLine

            Select Case aukera
                Case 1
                    probatuIkasleaLortu()
                Case 2
                    probaIkasleaTxertatu()
                Case 3
                    probaEgiaztatu()
                Case 4
                    probaIkaslearenPasahitzaAldatu()
                Case Else
            End Select

        End While

        '----------------KONEXIOA ITXI------------------------------
        'Itxi konexioa
        DBKudeatzailea.DatuAtzipena.ItxiKonexioa()
        '------------------------------------------------------------

    End Sub

End Module

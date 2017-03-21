Imports System.Data.OleDb
Imports System.Web

Public Class DatuAtzipena

    'CONEXIO OROKORRA
    Private Shared conSGTA_Lanak As OleDbConnection

    'eraikitzaile pribatua (singleton patroia):
    Private Sub New()
    End Sub

    'metodoak Shared (singleton patroia):
    Public Shared Function Konektatu(ByVal Patha As String) As OleDbConnection
        Dim strConSGTA_Lanak As String =
        "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & Patha
        Try
            conSGTA_Lanak = New OleDbConnection(strConSGTA_Lanak)
            'modu deskonektatuan ez da open behar, fill egiten du
            conSGTA_Lanak.Open()
            Return conSGTA_Lanak
        Catch ex As Exception
            Throw New ErroreaKonektatzean(ex.Message & " salb. tratatu dugu, ErroreaKonektatzean jaurtiz")
        End Try
    End Function

    Public Shared Sub ItxiKonexioa()
        conSGTA_Lanak.Close()
    End Sub

    Public Shared Function IkasleaTxertatu(ByVal gure_ikasle As Ikaslea) As Integer
        'txertatutako erregistro kopurua (Integer) itzultzen du emaitzatzat
        Dim cmdIkasleak As OleDbCommand
        Dim strSQL As String = "INSERT INTO Ikasleak (" &
            "Email_Helbidea,Izena,Abizena,Pasahitza,Galdera_ezkutua,Galdera_ezkutuaren_erantzuna,Egiaztatze_zenbakia,Egiaztatua,erabiltzaileMota,na,azpitaldeKodea " &
            ") VALUES ('" & gure_ikasle.email_helbidea & "' , '" & gure_ikasle.izena & "' , '" & gure_ikasle.abizena & "' , '" & gure_ikasle.pasahitza &
            "' , '" & gure_ikasle.galdera_ezkutua & "' , '" & gure_ikasle.galdera_ezkutuaren_erantzunak & "' , " & gure_ikasle.egiaztatze_zenbakia &
            " , " & gure_ikasle.egiaztatua & " , " & gure_ikasle.erabiltzaileMota & " )"
        cmdIkasleak = New OleDbCommand(strSQL, conSGTA_Lanak)
        Try
            Return cmdIkasleak.ExecuteNonQuery() 'saiatu INSERT-a exekutatzen
        Catch ex As Exception
            Throw New ErroreaTxertatzean(ex.Message & " salb. tratatu dugu, ErroreaTxertatzean jaurtiz")
        End Try
    End Function

    Public Shared Function IkasleaLortu(ByVal gure_email As String) As Ikaslea

        'db datozten datuak
        Dim Datuak As OleDbDataReader
        Dim emaitza As New Ikaslea
        Dim strSQL As String = "SELECT * from Ikasleak Where Email_Helbidea = '" & gure_email & "'"
        Dim cmdIkasleak As OleDbCommand
        cmdIkasleak = New OleDbCommand(strSQL, conSGTA_Lanak)
        Try
            Datuak = cmdIkasleak.ExecuteReader
            If (Datuak.Read) Then
                emaitza.email_helbidea = Datuak.Item("Email_Helbidea")
                emaitza.izena = Datuak.Item("Izena")
                emaitza.abizena = Datuak.Item("Abizena")
                emaitza.pasahitza = Datuak.Item("Pasahitza")
                emaitza.galdera_ezkutua = Datuak.Item("Galdera_ezkutua")
                emaitza.galdera_ezkutuaren_erantzunak = Datuak.Item("Galdera_ezkutuaren_erantzuna")
                emaitza.egiaztatze_zenbakia = Datuak.Item("Egiaztatze_zenbakia")
                emaitza.egiaztatua = Datuak.Item("Egiaztatua")
                emaitza.erabiltzaileMota = Datuak.Item("erabiltzaileMota")
            End If

        Catch ex As Exception
            Throw New ErroreaIkasleaLortu()
        End Try

        Return emaitza

    End Function

    Public Shared Sub ikasleaEgiaztatu(ByVal helbidea As String)

        'txertatutako erregistro kopurua (Integer) itzultzen du emaitzatzat
        Dim strSQL As String = "UPDATE Ikasleak set Egiaztatua = true where Email_Helbidea   = '" & helbidea & "'"
        Dim cmdIkasleak As OleDbCommand
        cmdIkasleak = New OleDbCommand(strSQL, conSGTA_Lanak)
        Try
            cmdIkasleak.ExecuteNonQuery() 'saiatu INSERT-a exekutatzen
        Catch ex As Exception
            Throw New ErroreaikasleaEgiaztatu()
        End Try

    End Sub

    Public Shared Sub ikaslearenPasahitzaAldatu(ByVal email As String, ByVal pasahitza As String)

        'txertatutako erregistro kopurua (Integer) itzultzen du emaitzatzat
        Dim strSQL As String = "UPDATE Ikasleak set Pasahitza = '" & pasahitza & "'  where   Email_Helbidea   = '" & email & "'"
        Dim cmdIkasleak As OleDbCommand
        cmdIkasleak = New OleDbCommand(strSQL, conSGTA_Lanak)
        Try
            cmdIkasleak.ExecuteNonQuery() 'saiatu INSERT-a exekutatzen
        Catch ex As Exception
            Throw New ErroreaikaslearenPasahitzaAldatu()
        End Try

    End Sub

    Public Shared Function IkasleaMatrikulatutakoIrakasgaienEgokitzaileaEskuratu(ByVal email As String) As OleDbDataAdapter

        '----------- komandoa ---------------
        Dim komandoa As OleDbCommand
        komandoa = New OleDbCommand("SELECT DISTINCT irakasgaiKodea FROM KlasekoTaldeak WHERE kodea IN (SELECT  taldeKodea FROM IkasleakTaldeak WHERE email ='" & email & "')")
        'komandoa eta konexioa lotu
        komandoa.Connection = conSGTA_Lanak

        '----------- adapter -----------------
        Dim adapter As New OleDbDataAdapter
        'adapter-rari Select agindutzat komandoa jarri
        adapter.SelectCommand = komandoa
        'adapter itzuli
        Return adapter

    End Function

    
    Public Shared Function UstiapenekoLanGenerikoenEgokitzaileaEskuratu() As OleDbDataAdapter

        '----------- komandoa ---------------
        Dim komandoa As OleDbCommand
        komandoa = New OleDbCommand("SELECT DISTINCT kodea,deskribapena,aurreikusitakoOrduak,lanMota,irakasgaiKodea FROM LanGenerikoak where ustiapenean=true ")
        'komandoa eta konexioa lotu
        komandoa.Connection = conSGTA_Lanak

        '----------- adapter -----------------
        Dim adapter As New OleDbDataAdapter
        'adapter-rari Select agindutzat komandoa jarri
        adapter.SelectCommand = komandoa
        'adapter itzuli
        Return adapter

    End Function

    Public Shared Function IkasleLanenEgokitzaileaEskuratu(ByVal email As String) As OleDbDataAdapter
        '----------- komandoa ---------------
        Dim komandoa As OleDbCommand
        komandoa = New OleDbCommand("SELECT DISTINCT email,lanGenerikoarenKodea,aurreikusitakoOrduak,benetakoOrduak FROM IkasleakLanak WHERE email = '" & email & "'  ")
        'komandoa eta konexioa lotu
        komandoa.Connection = conSGTA_Lanak

        '----------- adapter -----------------
        Dim adapter As New OleDbDataAdapter
        'adapter-rari Select agindutzat komandoa jarri
        adapter.SelectCommand = komandoa
        'adapter itzuli
        Return adapter

    End Function
    Public Shared Function LanGenerikoenEgokitzaileaEskuratu() As OleDbDataAdapter
        '----------- komandoa ---------------
        Dim komandoa As OleDbCommand
        komandoa = New OleDbCommand("SELECT * FROM LanGenerikoak  ")
        'komandoa eta konexioa lotu
        komandoa.Connection = conSGTA_Lanak

        '----------- adapter -----------------
        Dim adapter As New OleDbDataAdapter
        'adapter-rari Select agindutzat komandoa jarri
        adapter.SelectCommand = komandoa
        'adapter itzuli
        Return adapter

    End Function
    Public Shared Function LanGenerEgokitEskuratuIrakasgaiKodearekin(ByVal irakasgaiKodea As String) As OleDbDataAdapter
        '----------- komandoa ---------------
        Dim komandoa As OleDbCommand
        komandoa = New OleDbCommand("SELECT * FROM LanGenerikoak WHERE irakasgaiKodea='" & irakasgaiKodea & "'")
        'komandoa eta konexioa lotu
        komandoa.Connection = conSGTA_Lanak

        '----------- adapter -----------------
        Dim adapter As New OleDbDataAdapter
        'adapter-rari Select agindutzat komandoa jarri
        adapter.SelectCommand = komandoa
        'adapter itzuli
        Return adapter

    End Function
    '--------------------- SALBUESPENAK -------------------------------------------------------------------------
    Public Class ErroreaKonektatzean
        Inherits ApplicationException 'aplikazio-salbuespenen klasea
        'eraikitzailea birdefinitu (gurasoarenaz baliatuz)
        Public Sub New(Optional ByVal Mezua As String = "Errorea: Ezin izan da datu-basearekiko konexioa egin.")
            MyBase.New(Mezua) 'gurasoaren eraikitzaileari deituz
        End Sub
    End Class

    Public Class ErroreaTxertatzean
        Inherits ApplicationException 'aplikazio-salbuespenen klasea
        'eraikitzailea birdefinitu (gurasoarenaz baliatuz)
        Public Sub New(Optional ByVal Mezua As String = "Errorea: Ezin izan da ikaslea txertatu")
            MyBase.New(Mezua) 'gurasoaren eraikitzaileari deituz
        End Sub
    End Class


    Public Class ErroreaIkasleaLortu
        Inherits ApplicationException 'aplikazio-salbuespenen klasea
        'eraikitzailea birdefinitu (gurasoarenaz baliatuz)
        Public Sub New(Optional ByVal Mezua As String = "Errorea: Ezin izan da ikaslea aurkitu")
            MyBase.New(Mezua) 'gurasoaren eraikitzaileari deituz
        End Sub
    End Class

    Public Class ErroreaikasleaEgiaztatu
        Inherits ApplicationException 'aplikazio-salbuespenen klasea
        'eraikitzailea birdefinitu (gurasoarenaz baliatuz)
        Public Sub New(Optional ByVal Mezua As String = "Errorea: Ezin izan da ikaslea egiaztatu true jarri")
            MyBase.New(Mezua) 'gurasoaren eraikitzaileari deituz
        End Sub
    End Class
    Public Class ErroreaikaslearenPasahitzaAldatu
        Inherits ApplicationException 'aplikazio-salbuespenen klasea
        'eraikitzailea birdefinitu (gurasoarenaz baliatuz)
        Public Sub New(Optional ByVal Mezua As String = "Errorea: Ezin izan da ikaslea pasahitza aldatu")
            MyBase.New(Mezua) 'gurasoaren eraikitzaileari deituz
        End Sub
    End Class



End Class


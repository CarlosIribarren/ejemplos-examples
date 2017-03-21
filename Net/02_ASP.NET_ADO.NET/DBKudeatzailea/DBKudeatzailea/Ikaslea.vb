Public Class Ikaslea

    Private n_email_helbidea As String
    Private n_izena As String
    Private n_abizena As String
    Private n_pasahitza As String
    Private n_galdera_ezkutua As String
    Private n_galdera_ezkutuaren_erantzunak As String
    Private n_egiaztatze_zenbakia As Integer
    Private n_egiaztatua As Boolean
    Private n_erabiltzaileMota As String
   

    Public Sub New()
    End Sub

    Public Property email_helbidea As String
        Get
            Return n_email_helbidea
        End Get
        Set(ByVal value As String)
            n_email_helbidea = value
        End Set
    End Property

    Public Property izena As String
        Get
            Return n_izena
        End Get
        Set(ByVal value As String)
            n_izena = value
        End Set
    End Property

    Public Property abizena As String
        Get
            Return n_abizena
        End Get
        Set(ByVal value As String)
            n_abizena = value
        End Set
    End Property

    Public Property pasahitza As String
        Get
            Return n_pasahitza
        End Get
        Set(ByVal value As String)
            n_pasahitza = value
        End Set
    End Property

    Public Property galdera_ezkutua As String
        Get
            Return n_galdera_ezkutua
        End Get
        Set(ByVal value As String)
            n_galdera_ezkutua = value
        End Set
    End Property

    Public Property galdera_ezkutuaren_erantzunak As String
        Get
            Return n_galdera_ezkutuaren_erantzunak
        End Get
        Set(ByVal value As String)
            n_galdera_ezkutuaren_erantzunak = value
        End Set
    End Property

    Public Property egiaztatze_zenbakia As Integer
        Get
            Return n_egiaztatze_zenbakia
        End Get
        Set(ByVal value As Integer)
            n_egiaztatze_zenbakia = value
        End Set
    End Property

    Public Property egiaztatua As Boolean
        Get
            Return n_egiaztatua
        End Get
        Set(ByVal value As Boolean)
            n_egiaztatua = value
        End Set
    End Property

    Public Property erabiltzaileMota As String
        Get
            Return n_erabiltzaileMota
        End Get
        Set(ByVal value As String)
            n_erabiltzaileMota = value
        End Set
    End Property

End Class

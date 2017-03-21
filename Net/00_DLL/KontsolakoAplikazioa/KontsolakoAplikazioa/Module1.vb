Module Module1

    Sub Main()

        Dim GureDLL As New BEZarenKalkulua.BEZa

        Console.WriteLine("kaixo sartu zenbakia : ")
        Dim totala As Double = Console.ReadLine

        Console.WriteLine("sartu bez mota : ")
        Dim mota As String = Console.ReadLine

        Console.WriteLine(" emaitza : ")

        Dim emaitza As New BEZarenKalkulua.Emaitza

        emaitza = GureDLL.Kalkulua(totala, mota)

        Console.WriteLine("bez gabe" + emaitza.lortu_BEZgabe.ToString)
        Console.WriteLine("bez arekin" + emaitza.lortu_BEZarekin.ToString)


        Dim azkena As Double = Console.ReadLine




    End Sub

End Module

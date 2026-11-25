$root = "D:\STS4-workspace\MibbeunProject\src"
$utf8NoBom  = New-Object System.Text.UTF8Encoding($false)
$utf8Strict = New-Object System.Text.UTF8Encoding($false, $true)
$cp949      = [System.Text.Encoding]::GetEncoding(949)

Get-ChildItem $root -Recurse -Include *.java | ForEach-Object {
    $bytes  = [System.IO.File]::ReadAllBytes($_.FullName)
    $hasBom = $bytes.Length -ge 3 -and $bytes[0] -eq 0xEF -and $bytes[1] -eq 0xBB -and $bytes[2] -eq 0xBF

    if ($hasBom) {
        $text = $utf8Strict.GetString($bytes, 3, $bytes.Length - 3); $why = "BOM 제거"
    } else {
        try   { $null = $utf8Strict.GetString($bytes); return }   # 이미 정상 UTF-8 → 건너뜀
        catch { $text = $cp949.GetString($bytes); $why = "MS949 → UTF-8" }
    }
    [System.IO.File]::WriteAllText($_.FullName, $text, $utf8NoBom)
    Write-Host "$why : $($_.FullName)"
}
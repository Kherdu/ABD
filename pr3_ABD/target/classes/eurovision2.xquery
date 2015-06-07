xquery version "3.0";

declare variable $anyo as xs:integer := 2015;

for $ed in doc("eurovision.xml")/eurovision/edicion
for $pais in $ed/pais
let $artista := doc("eurovision.xml")//artista[@id=$pais/participante/@id]
let $puntuacion := sum($ed//votos[@id_pais=$pais/@nombre])
where $ed/@numero=$anyo
order by $puntuacion descending
return <clasificacion pais=" {data($pais/@nombre)} " cancion=" {$pais/cancion/text()} "
artista=" {$artista/nombre/text()} " puntos=" {$puntuacion} "/>



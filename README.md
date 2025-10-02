# Respostas
### 1)Explique detalhadamente como o gerenciamento de ciclo de vida de uma Activity impacta a performance e o gerenciamento 
de memória em um aplicativo Android, especialmente em cenários de múltiplas Activitys e rotacionamento de tela. Como os 
métodos onSaveInstanceState() e onRestoreInstanceState() podem ser usados para garantir que dados cruciais não sejam perdidos, 
e como isso se relaciona com o conceito de "State Restoration" em sistemas móveis?
R: 
- O onSaveInstance é um parâmetro de função utilizado para guardar informações entre uma transição entre telas.
- O onRestoreInstance como o próprio nome já diz, restaura uma instancia passada de uma tela para outra.
- Utilizadas para evitar perda de dados caso ocorram problemas no programa ou no sistema operacional e quando ocorre a rotatividade da tela (forma horizontal).


### 2)Explique os principais artefatos disponíveis em um projeto Android como manifesto, res , R, Activitys 
R: 
- Manifest: O arquivo AndroidManifest.xml guarda as principais informações sobre a aplicação, como nome, versão do android, as activities etc.
- res: Pasta onde é armazenado os recursos (resources (res)) da aplicação android, como imagens, textos globais etc.
- R: Utilizado para realizar referência para os recursos da pasta res.
- Activities: Utilizado para realizar a interação com o usuário final da aplicação, ligando a lógica e o usuário da aplicação.
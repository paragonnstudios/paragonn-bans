<div align="center">

# 🛡️ Paragonn Bans

[![Minecraft](https://img.shields.io/badge/Minecraft-1.6%2B-brightgreen?style=for-the-badge&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOCAYAAAAfSC3RAAAACXBIWXMAAAsTAAALEwEAmpwYAAAA)](https://www.minecraft.net/)
[![Java](https://img.shields.io/badge/Java-8%2B-red?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spigot](https://img.shields.io/badge/Spigot-Compatible-orange?style=for-the-badge)](https://www.spigotmc.org/)
[![Bukkit](https://img.shields.io/badge/Bukkit-Compatible-yellow?style=for-the-badge)](https://dev.bukkit.org/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)
[![VisualVM](https://img.shields.io/badge/Profiler-VisualVM-purple?style=for-the-badge&logo=visualstudio&logoColor=white)](https://visualvm.github.io/)

**Um plugin de banimento robusto, leve e completo para servidores Minecraft.**  
*Baseado no PBans — reescrito, otimizado e adaptado para o Paragonn Network.*

</div>

---

## 📋 Sobre

O **Paragonn Bans** nasceu da necessidade de ter uma solução de moderação que realmente funcionasse — sem bugs, sem travamentos, sem complicação. A maioria dos plugins de ban disponíveis ou eram uma piada, ou foram feitos exclusivamente para servidores Premium.

Este plugin foi construído e testado extensivamente em servidores **Offline-Mode**, garantindo que seja sólido como pedra e leve como pena. Ele traz de volta tudo que deveria existir nativamente no Minecraft: mutes temporários, banimentos por IP, detecção de IPs duplicados, autocompletar de nomes e muito mais.

> 🔬 **Profiling de performance** realizado com **[VisualVM](https://visualvm.github.io/)** — o Java Profiler utilizado para garantir que o plugin não impacte o desempenho do servidor.

---

## 🗄️ Banco de Dados

| Tipo | Suporte |
|------|---------|
| 🐬 MySQL | ✅ |
| 📁 SQLite (arquivo local) | ✅ |

---

## ✨ Funcionalidades

| # | Funcionalidade |
|---|----------------|
| 1 | 🔒 **Lockdown total do servidor** — impede qualquer jogador de entrar com uma mensagem personalizada (ideal contra ataques de bots) |
| 2 | 🔤 **Autocompletar nomes** — funciona mesmo com jogadores offline |
| 3 | ⚠️ **Sistema de advertências** — com ações automáticas configuráveis |
| 4 | 🔍 **Detecção de IPs duplicados** — identifica contas alternativas |
| 5 | 🌐 **Consulta DNSBL** — bloqueia proxies automaticamente |
| 6 | 📜 **Mensagens de kick em múltiplas linhas** — sem cortes na tela |
| 7 | 🔔 **Notificações** — avisa a staff quando um banido tenta entrar |
| 8 | ⏱️ **Tempos relativos** — exibe "banido por 4 minutos e 6 segundos" ao invés de um horário absoluto |
| 9 | 🎨 **Cores totalmente personalizáveis** — cada mensagem do seu jeito |
| 10 | 🚫 **Bloqueio de comandos durante mute** — impede o uso de `/me`, `/say` e outros |

---

## 🎮 Comandos

### 🔨 Banimentos

| Comando | Descrição |
|---------|-----------|
| `/ban <jogador\|IP> <motivo>` | Bane um jogador permanentemente |
| `/unban <jogador\|IP>` | Remove o banimento de um jogador ou IP |
| `/tempban <jogador\|IP> <tempo> <formato> <motivo>` | Banimento temporário |
| `/ipban <jogador\|IP> <motivo>` | Banimento por IP |
| `/tempipban <jogador\|IP> <tempo> <formato> <motivo>` | Banimento temporário por IP |
| `/rangeban <IP1-IP2> [motivo]` | Bane um intervalo de IPs |
| `/temprangeban <IP1-IP2> <tempo> <formato> [motivo]` | Banimento temporário por range de IP |
| `/unrangeban <IP>` | Remove qualquer range ban que inclua o IP informado |

### 🔇 Mutes

| Comando | Descrição |
|---------|-----------|
| `/mute <jogador>` | Silencia ou dessilencia um jogador |
| `/unmute <jogador>` | Remove o silêncio de um jogador |
| `/tempmute <jogador> <tempo> <formato>` | Silencia temporariamente |

### ⚠️ Advertências

| Comando | Descrição |
|---------|-----------|
| `/warn <jogador> <motivo>` | Dá uma advertência ao jogador |
| `/unwarn <jogador>` | Remove a advertência mais recente |
| `/clearwarnings <jogador>` | Limpa todas as advertências |

### 🔎 Consultas

| Comando | Descrição |
|---------|-----------|
| `/checkban <jogador\|IP>` | Exibe o status de banimento |
| `/checkip <jogador>` | Exibe o IP do jogador |
| `/dupeip <jogador\|IP>` | Lista contas com o mesmo IP |
| `/history [jogador] [registros]` | Exibe histórico de bans, kicks e mutes |

### 🛠️ Administração

| Comando | Descrição |
|---------|-----------|
| `/kick <jogador\|*> [motivo]` | Expulsa um jogador (use `*` para todos) |
| `/lockdown [motivo]` | Ativa/desativa o lockdown do servidor |
| `/forcespawn <jogador>` | Teleporta ao spawn (2x, para invalidar o `/back`) |
| `/mbwhitelist <jogador>` | Permite que o jogador ignore banimentos por IP |
| `/immune <jogador> <true\|false>` | Concede ou remove imunidade a punições |
| `/mbreload` | Recarrega o plugin completamente |
| `/mbimport` | Importa banimentos de outros plugins/formatos |
| `/mbexport` | Exporta banimentos para vanilla, MySQL ou SQLite |
| `/mbdebug File\|Chat\|Console` | Exibe informações de depuração |

> 💡 **Dica:** Adicione `-s` em qualquer comando para executá-lo silenciosamente, sem anunciar para os jogadores.  
> Exemplo: `/tempban Jogador123 -s 1 hour Motivo` — o jogador sai sem nenhum anúncio visível.

---

## 🔐 Permissões

Todas as permissões seguem o padrão `maxbans.<nomeDoComando>`, com as seguintes exceções:

| Permissão | Descrição |
|-----------|-----------|
| `maxbans.lockdown.use` | Usar `/lockdown on\|off` |
| `maxbans.lockdown.bypass` | Entrar no servidor durante lockdown |
| `maxbans.kick.*` | Usar `/kick *` (expulsar todos) |
| `maxbans.notify` | Receber notificações de proxy/banido tentando entrar |
| `maxbans.checkban.self` | Ver seus próprios banimentos e advertências |
| `maxbans.seesilent` | Ver comandos silenciosos usados por outros |
| `maxbans.seebroadcast` | Ver anúncios de kick/ban de outros (padrão: true) |

---

## ⚙️ Dependências

- **CraftBukkit** ou **Spigot** (disponíveis online)
- Bibliotecas incluídas na pasta `libs/`

---

## 🧱 Build com Gradle (IntelliJ)

Este projeto está configurado como **Gradle (módulo único)**:

- Projeto raiz: `paragonn-bans`
- Fontes Java: `main/java/src`
- Recursos: `main/java/resources`

### Importar no IntelliJ IDEA

1. `File > Open...`
2. Selecione a pasta raiz do repositório
3. Confirme a importação como projeto **Gradle**
4. Aguarde o sync baixar as dependências

### Comandos úteis

- Build: `./gradlew build`
- Gerar JAR: `./gradlew jar`

---

## 🌍 GeoIP

O Paragonn Bans baixa automaticamente um arquivo `GeoIP.csv` (~1.7MB) na primeira execução, permitindo identificar o país de origem dos endereços IP. O arquivo é baixado apenas uma vez e fica em cache até ser removido manualmente.

---

## 🙏 Créditos

Este plugin é baseado no **PBans**, desenvolvido originalmente por:

| Autor | Papel |
|-------|-------|
| **Netherfoam** | Criador original do PBans |
| **Darekfive** | Contribuidor |
| **FabioZumbi12** | Contribuidor |

> O projeto **Paragonn Bans** é uma adaptação do PBans, com traduções, melhorias e otimizações realizadas para o ambiente do Paragonn Network.

---

<div align="center">

Feito com ❤️ para o **Paragonn Network**

</div>
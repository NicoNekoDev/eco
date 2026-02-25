package com.willfp.eco.internal.spigot.integrations.economy

import com.willfp.eco.core.integrations.economy.EconomyIntegration
import net.milkbowl.vault2.economy.Economy
import org.bukkit.OfflinePlayer
import java.math.BigDecimal

class EconomyVaultUnlocked(
    private val vault: Economy
) : EconomyIntegration {
    override fun hasAmount(player: OfflinePlayer, amount: BigDecimal): Boolean {
        return vault.has("eco", player.uniqueId, amount)
    }

    override fun giveMoney(player: OfflinePlayer, amount: BigDecimal): Boolean {
        return vault.deposit("eco", player.uniqueId, amount).transactionSuccess()
    }

    override fun removeMoney(player: OfflinePlayer, amount: BigDecimal): Boolean {
        return vault.withdraw("eco", player.uniqueId, amount).transactionSuccess()
    }

    override fun getExactBalance(player: OfflinePlayer): BigDecimal {
        return vault.balance("eco", player.uniqueId)
    }

    override fun getPluginName(): String {
        return "Vault"
    }
}

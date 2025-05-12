# **PlayerMonitor Ultra**

**PlayerMonitor Ultra (PMU)** is an advanced administrative tool for Minecraft servers that tracks and links **player nicknames, IP addresses, and UUIDs**, along with login times and more. It's ideal for catching alt accounts, monitoring suspicious behavior, and keeping your server secure.

---

## 🔐 **Permissions**

* `pmu.admin` — Grants full access to all PMU commands.

---

## 💬 **Commands**

**Format:** `/pmu <from>-><to>`

| Command           | Description                                                          |
| ----------------- | -------------------------------------------------------------------- |
| `/pmu name->uuid` | Get a player's UUID by their nickname.                               |
| `/pmu name->ip`   | Get the player's IP address by their nickname.                       |
| `/pmu uuid->name` | Get all nicknames associated with a specific UUID.                   |
| `/pmu ip->name`   | Get all nicknames that have connected from the specified IP address. |

---

## 📊 **Features**

* Tracks and links **nicknames, UUIDs, and IP addresses**.
* Logs **first join and last seen** timestamps.
* Supports multiple UUIDs/IPs/nicknames per player for accurate tracking.
* Lightweight and easy-to-use command system for fast lookups.

---

## 📂 **Examples**

```
/pmu name->uuid Steve
→ 123e4567-e89b-12d3-a456-426614174000

/pmu ip->name 192.168.1.25
→ Steve, Alex, Notch

/pmu uuid->name 123e4567-e89b-12d3-a456-426614174000
→ Steve
```

---

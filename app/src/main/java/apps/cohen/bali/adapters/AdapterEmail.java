package apps.cohen.bali.adapters;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;
import android.widget.ArrayAdapter;

import java.util.HashSet;
import java.util.regex.Pattern;

public class AdapterEmail extends ArrayAdapter<String> {

    public AdapterEmail(Context context) {
        super(context, android.R.layout.simple_list_item_1);

        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(context).getAccounts();
        HashSet<String> set = new HashSet<String>(accounts.length);
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                set.add(account.name);
            }
        }

        addAll(set);
    }
}

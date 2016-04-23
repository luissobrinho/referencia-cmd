package br.com.ddsw.app.sssixtyfour;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView titlte, content;
    Application application;
    android.support.v7.app.ActionBar bar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:?subject=" + titlte.getText().toString() + "&body=" + content.getText().toString() + "Enviado de: Referências CMD.\nDownload: <a href='http://luiseduardo.ddsw.com.br/'>Referências CMD</a>"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        titlte = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        application = new Application();
        bar = getSupportActionBar();
        bar.setTitle("Início");
        if (savedInstanceState != null) {
            titlte.setText(savedInstanceState.getString("title"));
            content.setText(savedInstanceState.getString("content"));
            bar.setTitle(savedInstanceState.getString("bar"));
            fab.setVisibility(savedInstanceState.getInt("fab", View.INVISIBLE));
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sobre) {
            Intent intent = new Intent(Principal.this, NovaActitvity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fab.setVisibility(View.VISIBLE);
        if (id == R.id.nav_ADDUSERS) {


            titlte.setText("ADDUSERS.exe (Windows 2000 Resource Kit)");
            content.setText("Automate the creation of a large number of users. Addusers will still work in XP/2003 for later OS's consider using a PowerShell script with New-ADUser, Set-ADAccountPassword, Add-ADPrincipalGroupMembership and Enable-ADAccount\n" +
                    "\n" +
                    "Syntax\n" +
                    "\n" +
                    "  Create Users:\n" +
                    "            AddUsers /c filename [/s:x] [/?] Domain Password_options\n" +
                    "  Dump to file:\n" +
                    "            AddUsers /d{:u} filename [/s:x] [/?] Domain Password_options\n" +
                    "  Erase Users:\n" +
                    "            AddUsers /e filename [/s:x] [/?] Domain Password_options\n" +
                    "key\n" +
                    "\n" +
                    "   Filename   - The comma-delimited file that AddUsers uses for data.\n" +
                    "\n" +
                    "   /s:x       - Change the delimiter character used in filename to x.\n" +
                    "\t\t\t\t e.g. /s:~ would make the delimiter \"~\" \n" +
                    " \n" +
                    "   Domain     - Query the Primary Domain Controller (PDC) of domain.\n" +
                    "                You can also use \\\\Servername to specify the machine where user accounts are created or read. \n" +
                    "                AddUsers will use the local computer by default (if you do not specify Domain)\n" +
                    "\n" +
                    "   /c         - Create user accounts, local groups, and global groups as specified by filename.\n" +
                    "\n" +
                    "   /d{:u}     - Dump user accounts, local groups, and global groups to filename.\n" +
                    "The (:u) is an optional switch that causes current accounts to be written to the specified file in Unicode text format. Choosing to dump current user accounts does not save the account's passwords or any security information for the accounts.\n" +
                    "Note: Password information is not saved in a user account dump and if you use the same file to create accounts, all passwords of newly created accounts will be empty. To back up security information for accounts, use a Tape Backup.\n" +
                    "\n" +
                    "   /e         - Erase the user accounts specified in the file name. \n" +
                    "                CAUTION: Be careful when erasing user accounts, as it is not possible to recreate\n" +
                    "\t\t\t\t an account with the same SID. This option will not erase built-in accounts. \n" +
                    "\t\t\t\t\n" +
                    " Password_options\n" +
                    "   /p:        - Set account creation options, used along with any combination of the following:\n" +
                    "      * l     - Users do not have to change passwords at next logon.\n" +
                    "      * c     - Users cannot change passwords.\n" +
                    "      * e     - Passwords never expire. (implies l option)\n" +
                    "      * d     - Accounts disabled.\n" +
                    "                By default, all created users are required to change their password at logon.\n" +
                    "Example\n" +
                    "Create a comma-delimited text file, which contains the new users to be created. Following the Syntax as follows:\n" +
                    "\n" +
                    "[Users]\n" +
                    "User Name,Full name, Password, Description, HomeDrive, Homepath, Profile, Script\n" +
                    "\n" +
                    "e.g.\n" +
                    "\n" +
                    "[User]\n" +
                    "jimmye,James Edward Phillip II,,,,,,\n" +
                    "alexd,Alex Denuur,,,E:\\,E:\\users\\alexd,,\n" +
                    "ronj,Ron Jarook,ChangeThis,,E:\\,E:\\users\\ronj,,\n" +
                    "sarahs,Sarah Smith,,,,,,\n" +
                    "u0123,Mike Olarte,,,,,,\n" +
                    "\n" +
                    "Save the file as C:\\Users.txt and execute the command\n" +
                    "\n" +
                    "AddUsers MyDomain /c c:\\Users.txt /p:e");
        } else if (id == R.id.nav_ADmodcmd) {
            titlte.setText("ADmodcmd.exe");
            content.setText("Active Directory Bulk Modify Tool (Command Line Version) There is also a GUI for this tool called admodify.exe\n" +
                    "\n" +
                    "Syntax\n" +
                    "      admodcmd [-dn BaseDN] [-p pagesize] [-s] [-server servername]\n" +
                    "\t      [-f LDAPFilter] [modification]\n" +
                    "\n" +
                    "Key\n" +
                    "   -dn BaseDN      Base DN to begin the LDAP query.\n" +
                    "\n" +
                    "   modification    Modification to perform:\n" +
                    "                   Terminal Server Attributes | Exchange Related Attributes\n" +
                    "                   Mailbox Rights | User Account Settings | Custom Attributes                  \n" +
                    "\n" +
                    "   -p pagesize     LDAP Page size to use for query.\n" +
                    "\n" +
                    "   -s              Perform a subtree search \n" +
                    "                   (Default = one level search)\n" +
                    "\n" +
                    "   -server servername\n" +
                    "                   The server to make the changes to.\n" +
                    "                   by default, changes\tare made locally if on a DC.\n" +
                    "                   If on a member, DNS is used to find a DC.\n" +
                    "\n" +
                    "   -f LDAPFilter   A Valid LDAP filter to use when enumerating objects\n" +
                    "                   The default filter is (objectClass=user).   \n" +
                    "Changes made with ADModcmd can be undone, as long as the xml log file that logged the changes still exists. These log files are typically located in the same folder as the admodify executable.\n" +
                    "\n" +
                    "Syntax:\n" +
                    "      admodcmd [-dn BaseDN] [-p pagesize] [-s] [-server servername]\n" +
                    "         -undo logfilename -server servername]\n" +
                    "\n" +
                    "Key: \n" +
                    "   logfilename     The log file that contains the changes to be undone.\n" +
                    "   servername      The DC to write the changes to.\n" +
                    "                   by default, changes\tare made locally if on a DC.\n" +
                    "                   If on a member, DNS is used to find a DC.\n" +
                    "For information on users that were skipped during an undo process, refer to the undo.log file.");
        } else if (id == R.id.nav_BCDBOOT) {
            titlte.setText("BCDBOOT.exe (Windows 7 /2008)");
            content.setText("Set up a system partition, repair the boot environment located on the system partition.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      BCDBOOT source [/l locale] [/s volume-letter]\n" +
                    "         [/v] [/m [{OS Loader GUID}]]\n" +
                    "\n" +
                    "Options\n" +
                    "\n" +
                    "   source  The location of the Windows directory to use as the source for\n" +
                    "           copying boot-environment files.\n" +
                    "\n" +
                    "   /l      The locale. default = US English.\n" +
                    "\n" +
                    "   /s      The volume letter of the system partition.\n" +
                    "           The default is the system partition identified by the firmware.\n" +
                    "\n" +
                    "   /v      Enable verbose mode\n" +
                    "\n" +
                    "   /m      By default, merge only global objects.\n" +
                    "           If an OS Loader GUID is specified, merge the given loader object within\n" +
                    "           the system template to produce a bootable entry.\n" +
                    "BCDboot can also be run from Windows PE (Preinstallation Environment)\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Initialize the system partition using files from the operating system image installed on the C: volume:\n" +
                    "\n" +
                    "C:\\> bcdboot C:\\Windows\n" +
                    "\n" +
                    "Set the default BCD locale to Japanese, and copy BCD (Boot Configuration Data) files to drive S:\n" +
                    "\n" +
                    "C:\\> bcdboot C:\\Windows /l ja-jp /s S:\n" +
                    "\n" +
                    "Merge the OS loader in the current BCD store identified with the given GUID in the new BCD store:\n" +
                    "\n" +
                    "C:\\> bcdboot c:\\windows /m {d58d10c6-df53-11dc-878f-00064f4f4e08}");
        } else if (id == R.id.nav_BCDEDIT) {
            titlte.setText("BCDEDIT.exe (Vista+)");
            content.setText("Manage Boot Configuration Data (BCD) data stores. The objects and elements in the store effectively replace Boot.ini.\n" +
                    "BCDEdit improves upon and replaces the Bootcfg command on earlier versions of Windows.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      BCDEdit /Command [Argument1] [Argument2] ...\n" +
                    "\n" +
                    "Key\n" +
                    "   Store commands:\n" +
                    "\n" +
                    "      /createstore  Creates a new empty boot configuration data store.\n" +
                    "                    The created store is not a system store.\n" +
                    "\n" +
                    "      /export\t     Export the contents of the system store into a file.\n" +
                    "                    This file can be used later to restore the state of the system store.\n" +
                    "                    Valid only for the system store.\n" +
                    "\n" +
                    "      /import       Restore the state of the system store by using a backup data file\n" +
                    "                    previously generated with /export.\n" +
                    "                    This command deletes any existing entries in the system store before\n" +
                    "                    the import takes place. Valid only for the system store.\n" +
                    "\n" +
                    "      /store        This option can be used with most BCDedit commands to specify\n" +
                    "                    the store to be used. If this option is not specified, then\n" +
                    "                    BCDEdit operates on the system store.\n" +
                    "                    Running the bcdedit /store command by itself is equivalent to running\n" +
                    "                    the bcdedit /enum active command.\n" +
                    "Administrative privileges are required to use BCDEdit to modify BCD.");
        } else if (id == R.id.nav_CACLS) {
            titlte.setText("CACLS.exe");
            content.setText("Display or modify Access Control Lists (ACLs) for files and folders. For Vista and greater use icacls.\n" +
                    "\n" +
                    "Access Control Lists apply only to files stored on an NTFS formatted drive, each ACL determines which users (or groups of users) can read or edit the file. When a new file is created it normally inherits ACL's from the folder where it was created.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      CACLS pathname [options]\n" +
                    "\t  \n" +
                    "Options:\n" +
                    "\n" +
                    "   /T   Search the pathname including all subfolders. (/TREE)\n" +
                    "   /E   Edit ACL, leave existing rights unchanged (/EDIT)\n" +
                    "   /C   Continue on access denied errors. (/CONTINUE)\n" +
                    "   /L   Work on the Symbolic Link itself versus the target (/LINK)\n" +
                    "   /M   Change ACLs of volumes mounted to a directory (/MOUNT)\n" +
                    "\n" +
                    "   /G user:permission\n" +
                    "        Grant access rights (/GRANT), permision can be:\n" +
                    "          R  Read \n" +
                    "          W  Write\n" +
                    "          C  Change (read/write) \n" +
                    "          F  Full control\n" +
                    "\t\t \n" +
                    "   /R user\n" +
                    "        Revoke specified user's access rights, only valid with /E. (/REVOKE)\n" +
                    "\n" +
                    "   /P user:permission\n" +
                    "        Replace access rights (/REPLACE), permission can be: \n" +
                    "          R  Read\n" +
                    "          W  Write\n" +
                    "          C  Change (read/write) \n" +
                    "          F  Full control\n" +
                    "          N  None\n" +
                    "\n" +
                    "   /D user\n" +
                    "        Deny access to user. (/DENY)\n" +
                    "\n" +
                    "   /S\n" +
                    "        Display the SDDL string for the DACL. (/SSDL)\n" +
                    "   /S:sddl\n" +
                    "        Replace the ACL(s) with those specified in the SDDL string\n" +
                    "        (not valid with /E, /G, /R, /P, or /D).\n" +
                    "\n" +
                    "   (The long /aliases in brackets are undocumented)\n" +
                    "In all the options above \"user\" can be a UserName or a group (either local or global)\n" +
                    "\n" +
                    "You can specify more than one user:permission in a single command.\n" +
                    "\n" +
                    "Wildcards can be used to specify multiple files.\n" +
                    "\n" +
                    "If a UserName or GroupName includes spaces then it must be surrounded with quotes e.g. \"Authenticated Users\"\n" +
                    "\n" +
                    "If no options are specified CACLS will display the ACLs for the file(s)\n" +
                    "\n" +
                    "Setting Deny permission (/D) will deny access to a user even if they also belong to a group that grants access.\n" +
                    "\n" +
                    "Limitations\n" +
                    "Cacls cannot display or modify the ACL state of files locked in exclusive use.\n" +
                    "\n" +
                    "Cacls cannot set the following permissions: change permissions, take ownership, execute, delete use XCACLS to set any of these.\n" +
                    "\n" +
                    "Using CACLS\n" +
                    "The CACLS command does not provide a /Y switch to automatically answer 'Y' to the Y/N prompt. However, you can pipe the 'Y' character into the CACLS command using ECHO, use the following syntax:\n" +
                    "\n" +
                    "ECHO Y| CACLS filename /g username:permission\n" +
                    "\n" +
                    "To edit a file you must have the \"Change\" ACL (or be the file's owner)\n" +
                    "To use the CACLS command and change an ACL requires \"FULL Control\"\n" +
                    "File \"Ownership\" will always override all ACL's - you always have Full Control over files that you create.\n" +
                    "If CACLS is used without the /E switch all existing rights on [pathname] will be replaced, any attempt to use the /E switch to change a [user:permission] that already exists will raise an error. To be sure the CALCS command will work without errors use /E /R to remove ACL rights for the user concerned, then use /E to add the desired rights.\n" +
                    "The /T option will only traverse subfolders below the current directory\n" +
                    "If no options are specified CACLS will display the current ACLs\n" +
                    "e.g. To display the current folder\n" +
                    "CACLS .\n" +
                    "Display permissions for one file \n" +
                    "CACLS MyFile.txt\n" +
                    "Display permissions for multiple files \n" +
                    "CACLS *.txt\n" +
                    "\n" +
                    "Inherited folder permissions are displayed as:\n" +
                    "\n" +
                    " OI - Object inherit    - This folder and files. (no inheritance to subfolders)\n" +
                    " CI - Container inherit - This folder and subfolders.\n" +
                    " IO - Inherit only      - The ACE does not apply to the current file/directory\n" +
                    " ID - Inherited         - The ACE was inherited from the parent directory's ACL.\n" +
                    "\n" +
                    "These can be combined as folllows:\n" +
                    " (OI)(CI)\t    This folder, subfolders, and files.\n" +
                    " (OI)(CI)(IO)\tSubfolders and files only.\n" +
                    "     (CI)(IO)  Subfolders only.\n" +
                    " (OI)    (IO)\tFiles only. \n" +
                    "So BUILTIN\\Administrators:(OI)(CI)F means that both files and Subdirectories will inherit 'F' (Fullcontrol) \n" +
                    "similarly (CI)R means Directories will inherit 'R' (Read folders only = List permission)\n" +
                    "\n" +
                    "To actually change the inheritance of a folder/directory use iCACLS /grant or iCACLs /deny\n" +
                    "\n" +
                    "When cacls is applied to the current folder only there is no inheritance and so no output.\n" +
                    "\n" +
                    "Errors when changing permissions\n" +
                    "If a user or group has a permission on a file or folder and you grant a second permission to the same user/group on the same folder, NTFS will sometimes produce the error message \"The parameter is incorrect\" To fix this (or prevent it happening) revoke the permission first /e /r and then apply a fresh grant /e /g\n" +
                    "\n" +
                    "No mapping between account names and security IDs was done\n" +
                    "This error indicates that cacls looked up the group or username given in Active Directory and didn't find anything, often this means that you need to prefix the name with a domain name ss64dom\\user64 or (for a local account) the name of the machine pc64\\localUser2 also check for simple typos.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "Add Read-Only permission to a single file \n" +
                    "CACLS myfile.txt /E /G \"Power Users\":R\n" +
                    "\n" +
                    "Add Full Control permission to a second group of users\n" +
                    "CACLS myfile.txt /E /G \"FinanceUsers\":F\n" +
                    "\n" +
                    "Now revoke the Read permissions from the first group\n" +
                    "CACLS myfile.txt /E /R \"Power Users\"\n" +
                    "\n" +
                    "Now give the first group Full-control:\n" +
                    "CACLS myfile.txt /E /G \"Power Users\":F\n" +
                    "\n" +
                    "Give the Finance group Full Control of a folder and all sub folders \n" +
                    "CACLS c:\\docs\\work /E /T /C /G \"FinanceUsers\":F");
        } else if (id == R.id.nav_CALL) {
            titlte.setText("CALL");
            content.setText("Call one batch program from another, or call a subroutine.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      CALL [drive:][path]filename [parameters]\n" +
                    "\n" +
                    "      CALL :label [parameters]\n" +
                    "\n" +
                    "      CALL internal_cmd\n" +
                    "\n" +
                    "Key:\n" +
                    "   pathname     The batch program to run.\n" +
                    "\n" +
                    "   parameters   Any command-line arguments.\n" +
                    "\n" +
                    "   :label       Jump to a label in the current batch script.\n" +
                    "\n" +
                    "   internal_cmd Run an internal command, first expanding any variables in the argument.\n" +
                    "CALL a second batch file\n" +
                    "The CALL command will launch a new batch file context along with any specified parameters. When the end of the second batch file is reached (or if EXIT is used), control will return to just after the initial CALL statement.\n" +
                    "\n" +
                    "Arguments can be passed either as a simple string or using a variable:\n" +
                    "\n" +
                    "CALL MyScript.cmd \"1234\"\n" +
                    "CALL OtherScript.cmd %_MyVariable%\n" +
                    "\n" +
                    "Example\n" +
                    "\n" +
                    "::----------start main.cmd-----------\n" +
                    "@Echo off \n" +
                    "CALL function.cmd 10 first \n" +
                    "Echo %_description% - %_number% \n" +
                    "\n" +
                    "CALL function.cmd 15 second \n" +
                    "Echo %_description% - %_number% \n" +
                    "::----------end main.cmd-------------\n" +
                    "\n" +
                    "::----------start function.cmd---------\n" +
                    "@Echo off\n" +
                    ":: Add 25 to %1\n" +
                    "SET /a _number=%1 + 25\n" +
                    ":: Store %2 \n" +
                    "SET _description=[%2]\n" +
                    "::----------end function.cmd-----------\n" +
                    "\n" +
                    "In many cases you will also want to use SETLOCAL and ENDLOCAL to keep variables in different batch files completely separate, this will avoid any potential problems if two scripts use the same variable name.\n" +
                    "\n" +
                    "If you execute a second batch file without using CALL you may run into some buggy behaviour: if both batch files contain a label with the same name and you have previously used CALL to jump to that label in the first script, you will find execution of the second script starts at the same label. Even if the second label does not exist this will still raise an error \"cannot find the batch label\". This bug can be avoided by always using CALL.\n" +
                    "\n" +
                    "CALL a subroutine (:label)\n" +
                    "The CALL command will pass control to the statement after the label specified along with any specified parameters.\n" +
                    "To exit the subroutine specify GOTO:eof this will transfer control to the end of the current subroutine.\n" +
                    "\n" +
                    "A label is defined by a single colon followed by a name. This is the basis of a batch file function.\n" +
                    "\n" +
                    "CALL :sub_display 123\n" +
                    "CALL :sub_display 456\n" +
                    "ECHO All Done\n" +
                    "GOTO :eof\n" +
                    "\n" +
                    ":sub_display\n" +
                    "ECHO The result is %1\n" +
                    "GOTO :eof\n" +
                    "\n" +
                    "At the end of the subroutine, GOTO :eof will return to the position where you used CALL.\n" +
                    "\n" +
                    "Passing by Reference\n" +
                    "In addition to passing numeric or string values on the command line, it is also possible to pass a variable name and then use the variable to transfer data between scripts or subroutines. Passing by reference is a slightly more advanced technique but can be particularly useful when the string contains characters that are CMD delimiters or quotes.\n" +
                    "    @Echo off\n" +
                    "    Echo:\n" +
                    "    Set \"var1=Red Pippin\"\n" +
                    "    Set \"var2=St Edmunds Pippin\"\n" +
                    "    Set \"var3=Egremont Russet\"\n" +
                    "\n" +
                    "    Echo: before: var1=%var1%  var2=%var2% var3=%var3%\n" +
                    "    call :myGetFunc var1 var2 var3\n" +
                    "    Echo: after: var1=%var1%  var2=%var2% var3=%var3%\n" +
                    "\n" +
                    "    Echo:&pause&goto:eof\n" +
                    "\n" +
                    "    ::----------------------------------------------\n" +
                    "    ::-- Function section starts below\n" +
                    "    ::----------------------------------------------\n" +
                    "\n" +
                    "    :myGetFunc    - passing a variable by reference\n" +
                    "    Set \"%~1=return64\"\n" +
                    "    Set \"%~3=return65\"\n" +
                    "    Goto:eof\n" +
                    "Buggy behaviour when using CALL\n" +
                    "Redirection with & | <> does not work as expected. \n" +
                    "If the CALL command contains a caret character within a quoted string \"test^ing\" , the carets will be doubled.\n" +
                    "\n" +
                    "Advanced usage : CALLing internal commands\n" +
                    "    CALL command [command_parameters]\n" +
                    "CALL can also be used to run any internal command (SET, ECHO etc) with the exception of FOR and IF.\n" +
                    "CALL will expand any variables passed on the same line. CALL REM only partly works: redirection operators, conditional execution operators and brackets will be not remarked.\n" +
                    "\n" +
                    "This is undocumented behaviour, in fact whenever CALL is run without a : prefix, it will always search disk for a batch file/executable called command before running the internal command. The effect of this extra disc access is that CALL SET is significantly slower than CALL, its use in loops or with a large number of variables should be avoided.\n" +
                    "\n" +
                    "Example\n" +
                    "\n" +
                    " @Echo off\n" +
                    " SETLOCAL\n" +
                    " set _server=frodo\n" +
                    " set _var=_server\n" +
                    " CALL SET _result=%%%_var%%%\n" +
                    " echo %_result%\n" +
                    "The line shown in bold has the '%' symbols tripled, CALL will expand this to: SET _result=frodo\n" +
                    "\n" +
                    "Each CALL does one substitution of the variables. (You can also do CALL CALL... for multiple substitutions)\n" +
                    "\n" +
                    "In many cases, DelayedExpansion is a better/faster method:\n" +
                    "\n" +
                    " @Echo Off\n" +
                    " Setlocal EnableDelayedExpansion\n" +
                    " Set _server=frodo\n" +
                    " Set _var=_server\n" +
                    " Set _result=!%_var%!\t\n" +
                    " Echo %_result%\n" +
                    "If you CALL an executable or resource kit utility make sure it's available on the machine where the batch will be running, test for it's existence with an IF command and throw an error if missing.\n" +
                    "\n" +
                    "CALL is an internal command, (internally it is closely related to GOTO).\n" +
                    "If Command Extensions are disabled, the CALL command will not accept batch labels. ");
        } else if (id == R.id.nav_DATE) {
            titlte.setText("DATE");
            content.setText("Display or change the date.\n" +
                    "\n" +
                    "Syntax\n" +
                    "\n" +
                    "to display the date   \n" +
                    "      DATE /T\n" +
                    "\n" +
                    "to set the system date\n" +
                    "      DATE\n" +
                    "or\n" +
                    "      DATE <date_today>\n" +
                    "The default output from DATE /T in the United States is \"1/23/1997\" but this is dependent on the country/locale.\n" +
                    "The default short date and time formats for a selection of countries are as follows:\n" +
                    "\n" +
                    " Country/language  CountryCode Locale Date_format  Time_format\n" +
                    "\n" +
                    "   Argentina-Spanish     054   2C0A   23/01/1997   9:45:30 am\n" +
                    "__________________________________________\n" +
                    "   Australia             061   0C09   23/01/1997   9:45:30 AM\n" +
                    "__________________________________________\n" +
                    "   Austria               043   0C07   23.01.1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Brazil-Portuguese     055   0416   23/01/1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Belgium-French        032   080C   23/01/1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Belgium-Dutch         032   0813   23/01/1997   9:45:30\n" +
                    "__________________________________________\n" +
                    "   Canada-French         002   0C0C   1997-01-23  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Canada-English        002   1009   01/23/1997   9:45:30 AM\n" +
                    "__________________________________________\n" +
                    "   China/PRC-Chinese     086   0804   1997/1/23    9:45:30\n" +
                    "__________________________________________\n" +
                    "   China/HK-Chinese Trad 852   0C04   23/1/1997    9:45:30\n" +
                    "__________________________________________\n" +
                    "   Czech Republic        042   0405   23.1.1997    9:45:30 \n" +
                    "__________________________________________\n" +
                    "   Denmark               045   0406   23-01-1997  09.45.30\n" +
                    "__________________________________________\n" +
                    "   Finland               358   040B   23.1.1997    9:45:00\n" +
                    "__________________________________________\n" +
                    "   France                033   040C   23/01/1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Germany               049   0407   23.01.1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Greece                030   0408   23/01/1997   9:45:30 μμ\n" +
                    "__________________________________________\n" +
                    "   Hungary               036   040E   1997.01.23.  9:45:30 \n" +
                    "__________________________________________\n" +
                    "   India-Hindi           091   0439   23-01-1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   India-Bengali         091   0445   23-01-97    09.35.00 \n" +
                    "__________________________________________\n" +
                    "   India-Telugu          091   044A   23-01-97    09:45:30 \n" +
                    "__________________________________________\n" +
                    "   Italy                 039   0410   23/01/1997  09.45.30 \n" +
                    "__________________________________________\n" +
                    "   Japan                 081   0411   1997/01/23   9:45:30\n" +
                    "__________________________________________\n" +
                    "   Netherlands           031   0413   23-01-1997   9:45:30 \n" +
                    "__________________________________________\n" +
                    "   Norway                047   0414   23.01.1997  09:45:30 \n" +
                    "__________________________________________\n" +
                    "   Poland                048   0415   1997-01-23  09:45:30 \n" +
                    "__________________________________________\n" +
                    "   Portugal              351   0816   23-01-1997  09:45:30 \n" +
                    "__________________________________________\n" +
                    "   Spain                 034   0C0A   23/01/1997   9:45:30 \n" +
                    "__________________________________________\n" +
                    "   Sweden                046   041D   1997-01-23  09.45.30\n" +
                    "__________________________________________\n" +
                    "   Switzerland-French    041   100C   23.01.1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Switzerland-German    041   0807   23.01.1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   Switzerland-Italian   041   0810   23.01.1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   United Kingdom        044   0809   23/01/1997  09:45:30\n" +
                    "__________________________________________\n" +
                    "   United States         001   0409   1/23/1997    9:45:30 AM\n" +
                    "\n" +
                    "                                      Bold = 24 hour time\n" +
                    "The table above is based on Vista/Windows 7, in earlier versions of Windows the default short date format for most countries returns a 2 digit year.\n" +
                    "\n" +
                    "Other date and time formats\n" +
                    "The dates and time above are only default settings, in the Control Panel users can change the date and time format including the date separator, 12/24 hour time and leading/trailing characters. Take care not make cultural assumptions about the users chosen date or time format.\n" +
                    "\n" +
                    "The ISO standard 8601 defines a date and time format that can be used internationally: YYYY-MM-DD to avoid the confusion that is often caused by differences in language and local custom. ISO 8601 also recommends that 24 hour times have a leading zero (09:45), but not all countries follow this convention.\n" +
                    "\n" +
                    "Date Formats in the registry\n" +
                    "Short Date Format\n" +
                    "HKCU\\Control Panel\\International\\sShortDate\n" +
                    "\n" +
                    "Date Separator\n" +
                    "HKCU\\Control Panel\\International\\sDate\n" +
                    "\n" +
                    "Country Code\n" +
                    "HKCU\\Control Panel\\International\\iCountry\n" +
                    "Locale\n" +
                    "HKCU\\Control Panel\\International\\Locale\n" +
                    "DATE is an internal command. If Command Extensions are disabled DATE will not support the /T switch");
        } else if (id == R.id.nav_DEFRAG) {
            titlte.setText("DEFRAG");
            content.setText("Defragment hard drive.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      DEFRAG <volume> [-a] [-f] [-v] [-?]\n" +
                    "\n" +
                    "Options \n" +
                    "  volume  drive letter or mount point (d: or d:\\vol\\mountpoint)\n" +
                    "  -a      Analyze only\n" +
                    "  -f      Force defragmentation even if free space is low\n" +
                    "  -v      Verbose output\n" +
                    "Example:\n" +
                    "\n" +
                    "DEFRAG c:");
        } else if (id == R.id.nav_ECHO) {
            titlte.setText("ECHO");
            content.setText("Display messages on screen, turn command-echoing on or off.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      ECHO [ON | OFF] \n" +
                    "      ECHO [message] \n" +
                    "Key\n" +
                    "   ON      : Display each line of the batch on screen (default)\n" +
                    "   OFF     : Only display the command output on screen\n" +
                    "   message : a string of characters to display\n" +
                    "Type ECHO without parameters to display the current echo setting (ON or OFF).\n" +
                    "\n" +
                    "In most batch files you will want ECHO OFF, turning it ON can be useful when debugging a problematic batch script.\n" +
                    "\n" +
                    "In a batch file, the @ symbol is the same as ECHO OFF applied to the current line only.\n" +
                    "\n" +
                    "Normally a command is executed and takes effect from the next line onwards, @ is a rare example of a command that takes effect immediately.\n" +
                    "\n" +
                    "Command characters will normally take precedence over the ECHO statement\n" +
                    "e.g. The redirection and pipe characters: & < > | ON OFF\n" +
                    "\n" +
                    "To override this behaviour you can escape each command character with ^ as follows:\n" +
                    "\n" +
                    "   ECHO Nice ^&Easy\n" +
                    "   ECHO Salary is ^> Commision\n" +
                    "   ECHO Name ^| Username ^| Expiry Date\n" +
                    "   ECHO:Off On Holiday\n" +
                    "Echo text into a FILE\n" +
                    "\n" +
                    "The general syntax is\n" +
                    "Echo This is some Text > FileName.txt\n" +
                    "\n" +
                    "or if you want to avoid extra spaces: \n" +
                    "Echo Some more text>FileName.txt\n" +
                    "\n" +
                    "Echo a Variable\n" +
                    "\n" +
                    "To display a department variable:\n" +
                    "\n" +
                    "ECHO %_department%\n" +
                    "\n" +
                    "An alternative is to separate with : instead of a space, this has some performance benefits.\n" +
                    "\n" +
                    "ECHO:%_department%\n" +
                    "\n" +
                    "If the variable does not exist - ECHO will simply return the text \"%_department%\"\n" +
                    "\n" +
                    "This can be extended to search and replace parts of a variable or display substrings of a variable.\n" +
                    "\n" +
                    "Echo a file\n" +
                    "\n" +
                    "Use the TYPE command.\n" +
                    "\n" +
                    "Echo a sound\n" +
                    "\n" +
                    "The following command in a batch file will trigger the default beep on most PC's\n" +
                    "\n" +
                    "ECHO \u0007 (^G)\n" +
                    "To type the BELL character use Ctrl-G or 'Alt' key, and 7 on the numeric keypad. (ascii 7)\n" +
                    "\n" +
                    "Alternatively using Windows Media Player:\n" +
                    "\n" +
                    "START/min wmplayer.exe %windir%\\media\\ding.wav\n" +
                    "\n" +
                    "(In Windows XP use sndrec32.exe or mplay32.exe)\n" +
                    "\n" +
                    "Echo a blank line\n" +
                    "\n" +
                    "The following in a batch file will produce an empty line:\n" +
                    "Echo.\n" +
                    "or\n" +
                    "Echo:\n" +
                    "The second option is better, because Echo. will search for a file named \"echo\" if this file does not exist the command does work, but this makes it slower than echo(\n" +
                    "\n" +
                    "To ECHO text without including a CR/LF (source)\n" +
                    "<nul (set/p _any_variable=string to emit)\n" +
                    "\n" +
                    "Echo text into a stream\n" +
                    "\n" +
                    "Streams allow one file to contain several separate forks of information (like the macintosh resource fork) \n" +
                    "\n" +
                    "The general syntax is\n" +
                    "\n" +
                    "   Echo Text_String > FileName:StreamName\n" +
                    "Only the following commands support the File:Stream syntax - ECHO, MORE, FOR\n" +
                    "\n" +
                    "Creating streams:\n" +
                    "\n" +
                    "   Echo This is stream1 > myfile.dat:stream1 \n" +
                    "   Echo This is stream2 > myfile.dat:stream2  \n" +
                    "Displaying streams:\n" +
                    "\n" +
                    "   More < myfile.dat:stream1 \n" +
                    "   More < myfile.dat:stream2\n" +
                    "   \n" +
                    "   FOR /f \"delims=*\" %%G in (myfile.dat:stream1) DO echo %%G\n" +
                    "   FOR /f \"delims=*\" %%G in (myfile.dat:stream2) DO echo %%G\n" +
                    "A data stream file can be successfully copied and renamed despite the fact that most applications and commands will report a zero length file. The file size can be calculated from remaining free space. The file must always reside on an NTFS volume.\n" +
                    "\n" +
                    "ECHO is an internal command.");
        } else if (id == R.id.nav_ENDLOCAL) {
            titlte.setText("ENDLOCAL");
            content.setText("End localisation of environment changes in a batch file. Pass variables from one batch file to another.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      ENDLOCAL\n" +
                    "If SETLOCAL is used to make variables 'local' to one batch script, then those variables will be invisible to all other batch scripts unless explicitly passed using an ENDLOCAL & SET... command.\n" +
                    "\n" +
                    "If SETLOCAL is used without a corresponding ENDLOCAL then local environment variables will be discarded when the batch file ends. Ending the cmd.exe session will discard all Environment Variables both local and global.\n" +
                    "\n" +
                    "If a batch script does not use SETLOCAL or ENDLOCAL then all variables will be Global, i.e. visible and modifiable from other calling scripts or on the command line after the script has completed.\n" +
                    "\n" +
                    "Passing variables from one routine to another\n" +
                    "The CMD command processor always works on a line-by-line basis, so it will convert all %variables% into their text values before executing any of the commands.\n" +
                    "\n" +
                    "By putting ENDLOCAL & SET commands on a single line you are able to SET a variable just before the localisation is ended by the ENDLOCAL command.\n" +
                    "\n" +
                    "ENDLOCAL does not reset %errorlevel%\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "::Sales.cmd\n" +
                    "   \n" +
                    "   @Echo off\n" +
                    "   SETLOCAL\n" +
                    "      Set _item=\"Ice Cream Maker\"\n" +
                    "      Set _price=450\n" +
                    "   ENDLOCAL & SET _return1=%_item%& SET _return2=%_price%\n" +
                    "\n" +
                    "::Results.cmd\n" +
                    "\n" +
                    "   @Echo off\n" +
                    "   SETLOCAL\n" +
                    "   CALL Sales.cmd\n" +
                    "   Echo [%_return1%] will cost [%_return2%]\n" +
                    "\n" +
                    "::SubDemo.cmd\n" +
                    "   \n" +
                    "   @Echo off\n" +
                    "   SETLOCAL\n" +
                    "   CALL sub_products\n" +
                    "   Echo [%_return1%] will cost [%_return2%]\n" +
                    "   goto:eof\n" +
                    "\n" +
                    "   :sub_products\n" +
                    "   SETLOCAL\n" +
                    "      Set _item=\"Coffee Grinder\"\n" +
                    "      Set _price=150\n" +
                    "   ENDLOCAL & SET _return1=%_item%& SET _return2=%_price%\n" +
                    "Multiple SET commands can be added to pass multiple variables, just prefix each with an &\n" +
                    "Be aware that any trailing spaces    will be added to the variables value.\n" +
                    "\n" +
                    "Improving readability\n" +
                    "The 'ENDLOCAL & SET' technique described above can become difficult to read if you have a lot of SET commands all on the same line. This can be made easier to read if you use parenthesis.\n" +
                    "\n" +
                    "Endlocal&(\n" +
                    "set _return1=%_item% \n" +
                    "set _return2=%_price%\n" +
                    "set _return3=%_discount%)\n" +
                    "\n" +
                    "In these examples we have used the variable names _return1, _return2 etc, but you can use any names for the return variables, even re-use the exact same variable name inside and outside the ENDLOCAL command (SET _price=%_price%)\n" +
                    "\n" +
                    "ENDLOCAL is an internal command.");
        } else if (id == R.id.nav_FC) {
            titlte.setText("FC.exe");
            content.setText("Compare the contents of two files or sets of files. Display any lines which do NOT match.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      FC /B pathname1 pathname2\n" +
                    "\n" +
                    "      FC [options] pathname1 pathname2\n" +
                    "\n" +
                    "Key\n" +
                    "   /B  : Perform a binary comparison.\n" +
                    "\n" +
                    "options\n" +
                    "   /C  : Do a case insensitive string comparison\n" +
                    "\n" +
                    "   /A  : Displays only first and last lines for each set of differences.\n" +
                    "\n" +
                    "   /U  : Compare files as UNICODE text files.\n" +
                    "   /L  : Compares files as ASCII text. (default)\n" +
                    "\n" +
                    "   /N  : Display line numbers (ASCII only)\n" +
                    "\n" +
                    "   /LBn: Limit the number of lines that will be read, \"n\" sets a maximum number\n" +
                    "         of consecutive differing lines after which the File Comparison will abort (resync failed)\n" +
                    "         When FC aborts then \"n\" number of mismatches will be shown.\n" +
                    "         default=100 lines.\n" +
                    "\n" +
                    "  /nnnn  : Specify a number of consecutive lines that must match after a mismatch.\n" +
                    "           This can be used to prevent the display of the two files from getting \n" +
                    "           too out of sync\n" +
                    "\n" +
                    "  /T     : Do not expand tabs to spaces.\n" +
                    "  /W     : Compress white space (tabs and spaces) for comparison.\n" +
                    "To compare sets of files, use wildcards in pathname1 and pathname2 parameters.\n" +
                    "\n" +
                    "Powershell also has an Alias FC for the Format-Custom cmdlet, therefore to run the 'old' FC under powershell you need to explicitly run C:\\windows\\system32\\fc.exe\n" +
                    "\n" +
                    "The messages returned by FC are language/locale dependent, so to identify 2 identical files use redirection syntax:\n" +
                    "\n" +
                    "   FC File1.txt File2.txt >NUL && Echo Same || Echo Different or error \n" +
                    "Errorlevels\n" +
                    "\n" +
                    "FC will set an ErrorLevel as follows:\n" +
                    "\n" +
                    "-1 Invalid syntax (e.g. only one file passed) \n" +
                    "0 The files are identical.\n" +
                    "1 The files are different.\n" +
                    "2 Cannot find at least one of the files.\n" +
                    "For an invalid switch (with two passed files) an error message is printed but the errorlevel is not changed.\n" +
                    "\n" +
                    "Example:\n" +
                    "\n" +
                    "If two files are compared and the four lines of text match as follows\n" +
                    "\n" +
                    "1: different\n" +
                    "2: same\n" +
                    "3: same\n" +
                    "4: different\n" +
                    "\n" +
                    "Specifying /nnnn =2 the file compare will display the 4th line and continue \n" +
                    "Specifying /nnnn =3 the file compare will halt at the 4th line (files too different)\n" +
                    "Specifying /LB1 the file compare will halt after the first line");
        } else if (id == R.id.nav_FIND) {
            titlte.setText("FIND");
            content.setText("Search for a text string in a file & display all the lines where it is found.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      FIND [/V] [/C] [/N] [/I] \"string\" [pathname(s)]\n" +
                    "\n" +
                    "Key\n" +
                    "   \"string\"   : The text string to find (must be in quotes).\n" +
                    "\n" +
                    "   [pathname] : A drive/file(s) to search (wildcards accepted).\n" +
                    "\n" +
                    "   /V  : Display all lines NOT containing the specified string.\n" +
                    "\n" +
                    "   /C  : Count the number of lines containing the string.\n" +
                    "\n" +
                    "   /N  : Display Line numbers.\n" +
                    "\n" +
                    "   /I  : Ignore the case of characters when searching for the string.\n" +
                    "If a [pathname] is not specified, FIND will prompt for text input or will accept text piped from another command.\n" +
                    "(use CTRL-Z to end manual text input)\n" +
                    "\n" +
                    "If searching for text that contains quote characters \" , they should be escaped by doubling to \"\"\n" +
                    "\n" +
                    "The FIND command will output a string of 10 dashes ---------- followed by the filename being searched, followed by any matching lines of text in the file.\n" +
                    "\n" +
                    "Errorlevel\n" +
                    "FIND will return an ErrorLevel as follows:\n" +
                    "\n" +
                    "0 String found in at least one of the files.\n" +
                    "1 String not found\n" +
                    "2 If any files in the list do not exist or if no files match a wildcard mask. An invalid switch is given.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "If names.txt contains the following:\n" +
                    "\n" +
                    "  Joe Bloggs, 123 Main St, Dunoon \n" +
                    "  Arnold Jones, 127 Scotland Street, Edinburgh\n" +
                    "To search for \"Jones\" in names.txt\n" +
                    "\n" +
                    "C:\\> FIND \"Jones\" names.txt\n" +
                    "\n" +
                    "---------- NAMES.TXT\n" +
                    "Arnold Jones, 127 Scotland Street, Edinburgh\n" +
                    "If you want to pipe the output from a command into FIND use this syntax\n" +
                    "\n" +
                    "C:\\> TYPE names.txt | FIND \"Jones\" \n" +
                    "You can also redirect like this\n" +
                    "\n" +
                    "C:\\> FIND /i \"Jones\" < names.txt >logfile.txt\n" +
                    "To search a folder for files that contain a given search string:\n" +
                    "\n" +
                    "C:\\> FOR %G IN (*.txt) do (find /n /i \"SearchWord\" \"%G\")\n" +
                    "Count the number of lines in a file:\n" +
                    "\n" +
                    "C:\\> TYPE myfile.txt | FIND \"\" /v /c\n" +
                    "Bugs/Limitations\n" +
                    "Although FIND can be used to scan large files, it will not detect any string that is positioned more than 1070 characters along a single line (with no carriage return) This makes it of limited use in searching binary or XML file types.");
        } else if (id == R.id.nav_GETMAC) {
            titlte.setText("GetMac.exe");
            content.setText("Display the Media Access Control (MAC) address and list of network protocols associated with each address for all network cards in each computer, either locally or across a network.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      getmac [/s Computer [/u Domain\\User [/p Password]]]\n" +
                    "         [/fo {TABLE|LIST|CSV}] [/nh] [/v]\n" +
                    "\n" +
                    "Key\n" +
                    "   /s Computer     The name or IP address of a remote computer\n" +
                    "                  (do not use backslashes). Default = local computer.\n" +
                    "\n" +
                    "   /u Domain\\User  Run the command with the account permissions of the\n" +
                    "                   user specified. Default = the currently logged on user.\n" +
                    "\n" +
                    "   /p Password     The password of the user account that is specified in the /u parameter.\n" +
                    "\n" +
                    "   /fo { TABLE | LIST | CSV } \n" +
                    "                   Format the output. Default = TABLE.\n" +
                    "\n" +
                    "   /nh   Omit the header row from the displayed driver information.\n" +
                    "         Valid when the /fo parameter is set to TABLE or CSV.\n" +
                    "\n" +
                    "   /v    Display verbose information.\n" +
                    "\n" +
                    "   /?    Display Help. \n" +
                    "Examples\n" +
                    "\n" +
                    "Show all MAC addresses in Table output:\n" +
                    "getmac /fo table /nh /v\n" +
                    "\n" +
                    "Show MAC addresses on server64 \n" +
                    "getmac /s server64\n" +
                    "\n" +
                    "Show MAC addresses on server64 and authenticate as a different user:\n" +
                    "getmac /s server64 /u ss64Dom\\user583\n" +
                    "\n" +
                    "Export a verbose listing of MAC addresses to a CSV file \n" +
                    "getmac /v /fo csv > T:\\macaddresses.csv\n" +
                    "\n" +
                    "PowerShell script to get the Mac address of the current machine:\n" +
                    "$Mac = getmac /fo csv | ConvertFrom-Csv\n" +
                    "\n" +
                    "PowerShell script to collect Mac addresses for multiple machines by calling GetMac:\n" +
                    "\n" +
                    "# Create empty hash table\n" +
                    "$macHash=@{}\n" +
                    "# Load a list of machine names\n" +
                    "$servers=get-content c:\\batch\\servers.txt\n" +
                    "foreach ($server in $servers) {\n" +
                    "   if (Test-Connection $server -quiet) {   # if it responds to a Ping\n" +
                    "      # Call the GetMac utility\n" +
                    "      $getmac=getmac /nh /fo csv /s $server\n" +
                    "      $macAddresses=$getmac -split \",\"\n" +
                    "      $interface = 1\n" +
                    "      $macAddresses | foreach {\n" +
                    "         if ($_ -ne \"\"){\n" +
                    "            # check for a '-' to see if we have a mac address\n" +
                    "            if ($_.substring(3,1) -eq \"-\") {\n" +
                    "               # Remove quotes\n" +
                    "               $addr = $_.replace(\"\"\"\",\"\")\n" +
                    "               $adapter = $interface/2\n" +
                    "               Echo \"$server  Adapter:$adapter  $addr\"\n" +
                    "               # Save in the hash variable\n" +
                    "               $macHash.add(\"$server Adapter:$adapter\",$addr)\n" +
                    "            }\n" +
                    "         }\n" +
                    "      $interface += 1\n" +
                    "      }\n" +
                    "   }\n" +
                    "}\n" +
                    "# Export the hash table to a spreadsheet\n" +
                    "$macHash.GetEnumerator() | select name, value | Sort-Object Name | Export-CSV -Path \"c:\\batch\\macaddresses.csv\" -NoTypeInformation");
        } else if (id == R.id.nav_GOTO) {
            titlte.setText("GOTO");
            content.setText("Direct a batch program to jump to a labelled line.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      GOTO label\n" +
                    "\n" +
                    "      GOTO:eof\n" +
                    "\n" +
                    "Key\n" +
                    "   label   A predefined label in the batch program.\n" +
                    "           Each label must be defined on a line by itself, beginning with\n" +
                    "           a colon and ending with either a space, a colon or a CR/LF.\n" +
                    "\n" +
                    "   :eof    This predefined label will exit the current subroutine or script.\n" +
                    "Using GOTO:eof will always transfer execution to the end of the current batch file or the end of the current subroutine. \n" +
                    "This can be written as GOTO:eof or GOTO :eof the space is optional.\n" +
                    "\n" +
                    "GOTO EOF and GOTO :EOF are not the same.\n" +
                    "if you create a label called eof, the command GOTO:eof will still exit the file/routine and not jump to the label.\n" +
                    "\n" +
                    "The command goto eof (without a colon) will jump to a label called eof, but to avoid confusion it is recommended that you use a different name goto nextsub\n" +
                    "\n" +
                    "goto:eof will automatically set an errorlevel (unlike Exit /b ).\n" +
                    "\n" +
                    "Although undocumented, GOTO :MySubroutine generally has the same effect as GOTO MySubroutine\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "A simple goto jump:\n" +
                    "\n" +
                    "GOTO sub_message\n" +
                    "   Echo this wont display\n" +
                    "goto:eof\n" +
                    "\n" +
                    ":sub_message\n" +
                    "   Echo this is a subroutine\n" +
                    "\n" +
                    "Use the %1 parameter to jump:\n" +
                    "\n" +
                    "IF %1==12 GOTO specialcase \n" +
                    "   Echo the input was NOT 12\n" +
                    "goto:eof \n" +
                    " \n" +
                    ":specialcase\n" +
                    "   Echo the input was  12\n" +
                    "goto:eof\n" +
                    "\n" +
                    "Use a variable as a label:\n" +
                    "   \n" +
                    "CHOICE /C:01 /m choose [Y]yes or [N]No \n" +
                    "   goto sub_%ERRORLEVEL% \n" +
                    "   \n" +
                    "   :sub_0 \n" +
                    "   Echo You typed Y for yes\n" +
                    "goto:eof \n" +
                    "\n" +
                    ":sub_1\n" +
                    "   Echo You typed N for no\n" +
                    "goto:eof\n" +
                    " \n" +
                    "Use a variable as a  comment\n" +
                    "In this example the COPY command will only run if the parameter \"Update\" is supplied to the batch:\n" +
                    "   \n" +
                    "@Echo Off \n" +
                    "Setlocal\n" +
                    "SET _skip=\n" +
                    "IF /I NOT %1==Update SET _skip=:: \n" +
                    "   \n" +
                    "%_skip% COPY x:\\update.dat \n" +
                    "%_skip% echo Update applied \n" +
                    " ...\n" +
                    "Bugs\n" +
                    "Using GOTO within parenthesis - including FOR and IF commands - will break their context:\n" +
                    "\n" +
                    "@echo off\n" +
                    "if A equ A (\n" +
                    " \t    GOTO :EXAMPLE_LABEL\n" +
                    " \t    :EXAMPLE_LABEL\n" +
                    "    rem\n" +
                    ") else (\n" +
                    " \techo You didn't expected to see this,did you?\n" +
                    ") \n" +
                    "An alternative is to replace the GOTO with a CALL to a subroutine. The subroutine can contain GOTO statements as they will be safely outside the parenthesis.\n" +
                    "\n" +
                    "GOTO breaks the & and && redirection operators.\n" +
                    "\n" +
                    "If GOTO a non existent label is used in conjunction with a negative conditional execution, the line containing the GOTO will be executed, but the rest of the Batch file is cancelled:\n" +
                    "\n" +
                    "goto :non_existent_label || Echo This line will run anything except GOTO ,SHIFT ,SETLOCAL , ENDLOCAL , CALL\n" +
                    ":SUBROUTINE echo This will be never displayed.\n" +
                    "GOTO is an internal command. If Command Extensions are disabled GOTO will no longer recognise the :EOF label");
        } else if (id == R.id.nav_HELP) {
            titlte.setText("HELP");
            content.setText("Online help for MS Windows - most commands will give help when run with /? or -? (COMMAND /? or COMMAND -?)\n" +
                    "\n" +
                    "GUI Help is available from START - Help or by running the help files directly:\n" +
                    "\n" +
                    "C:\\WINDOWS\\help\\ntcmds.chm\n" +
                    "C:\\WINDOWS\\help\\ntdef.chm\n" +
                    "C:\\WINDOWS\\help\\ntchowto.chm\n" +
                    "C:\\WINDOWS\\help\\nthelp.chm\n" +
                    "C:\\WINDOWS\\help\\ntshared.chm\n" +
                    "\n" +
                    "Syntax\n" +
                    "      WINHELP [options] helpfile.hlp\n" +
                    "\n" +
                    "      WINHLP32.exe [options] helpFile\n" +
                    "\n" +
                    "In XP:    C:\\WINDOWS\\PCHealth\\HelpCtr\\Binaries\\HelpCtr.exe\n" +
                    "\n" +
                    "options:\n" +
                    "\n" +
                    "-H    show help about help\n" +
                    "\n" +
                    "-G[n] Build a .gid file and quit,\n" +
                    "      If a number is specified, it determines which extensible tab to\n" +
                    "      display by default the first time the help file is opened.\n" +
                    "      A value of 1 would be the first tab beyond the Find tab.\n" +
                    "      This command cannot be used with -S.\n" +
                    "\n" +
                    "-S    Create a .gid file without showing an animated icon. \n" +
                    "      Cannot be used with -G. (winhlp32 only)\n" +
                    "\n" +
                    "-W window \n" +
                    "      Specify the window for displaying the topic.\n" +
                    "      This command cannot be used with -P.\n" +
                    "\n" +
                    "-P    Show the topic in a pop-up window. \n" +
                    "      This command cannot be used with -W. \n" +
                    "      You must use the -P switch in combination with the \n" +
                    "      -N (context number) or -I (topic ID) switch.\n" +
                    "\n" +
                    "-N contextNum | -I topicID\n" +
                    "      Specify the topic to open using either a topic number, \n" +
                    "      (defined in the [MAP] section of the HPJ file.)\n" +
                    "      or a topic ID string \n" +
                    "      (# footnote in the topic).\n" +
                    "\n" +
                    "-K keyword \n" +
                    "      Specify the topic to open using a keyword.\n" +
                    "      This command cannot be used with -N or -I.");
        } else if (id == R.id.nav_HOSTNAME) {
            titlte.setText("HOSTNAME.exe");
            content.setText("Display the host name portion of the full computer name of the computer.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      HOSTNAME\n" +
                    "\n" +
                    "Options\n" +
                    "\n" +
                    "   /? \t Display Help\n" +
                    "The hostname command is only available if the Internet Protocol (TCP/IP) is installed as a network component.\n" +
                    "\n" +
                    "The computer hostname is usually (but not always) the same as the %COMPUTERNAME% variable.\n" +
                    "\n" +
                    "When called with any argument other than /? hostname sets errorlevel to 1 and prints an error message.\n" +
                    "\n" +
                    "If the environment variable _CLUSTER_NETWORK_NAME_ exists and is populated, then HOSTNAME will return the value of that variable in place of the true Hostname.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Display the system hostname:\n" +
                    "\n" +
                    "C:\\> hostname");
        } else if (id == R.id.nav_iCACLS) {
            titlte.setText("iCACLS.exe (2003 sp2, Vista+)");
            content.setText("Change file and folder permissions - display or modify Access Control Lists (ACLs) for files and folders.\n" +
                    "iCACLS resolves various issues that occur when using the older CACLS & XCACLS\n" +
                    "\n" +
                    "Syntax\n" +
                    "      ICACLS Name [/grant[:r] User:Permission[...]]\n" +
                    "         [/deny User:Permission[...]]\n" +
                    "            [/remove[:g|:d]] User[...]]\n" +
                    "               [/inheritance:e|d|r ]\n" +
                    "                  [/t] [/c] [/l] [/q]\n" +
                    "                     [/setintegritylevel Level[...]]\n" +
                    "\n" +
                    "   Store ACLs for one or more directories matching name into aclfile for later use with /restore\n" +
                    "      ICACLS name /save aclfile [/T] [/C] [/L] [/Q]\n" +
                    "    \n" +
                    "   Restore ACLs to all files in directory :\n" +
                    "      ICACLS directory [/substitute SidOld SidNew [...]]\n" +
                    "          /restore aclfile [/C] [/L] [/Q]\n" +
                    "\n" +
                    "   Change Owner:\n" +
                    "      ICACLS name /setowner user [/T] [/C] [/L] [/Q]\n" +
                    "\n" +
                    "   Find items with an ACL that mentions a specific SID:\n" +
                    "      ICACLS name /findsid Sid [/T] [/C] [/L] [/Q]\n" +
                    "\n" +
                    "   Find files whose ACL is not in canonical form or with a length inconsistent with the ACE count:\n" +
                    "      ICACLS name /verify [/T] [/C] [/L] [/Q]\n" +
                    " \n" +
                    "   Replace ACL with default inherited acls for all matching files:\n" +
                    "      ICACLS name /reset [/T] [/C] [/L] [/Q]\n" +
                    "\n" +
                    "Key\n" +
                    "   name  The File(s) or folder(s) the permissions will apply to.\n" +
                    "\n" +
                    "   /T  Traverse all subfolders to match files/directories. \n" +
                    "   \n" +
                    "   /C  Continue on file errors (access denied)  Error messages are still displayed.\n" +
                    "  \n" +
                    "   /L  Perform the operation on a symbolic link itself, not its target.\n" +
                    "\n" +
                    "   /Q  Quiet - supress success messages.\n" +
                    "\t\n" +
                    "   /grant :r user:permission\n" +
                    "       Grant access rights, with :r, the permissions\n" +
                    "       will replace any previouly granted explicit permissions.\n" +
                    "       Otherwise the permissions are added.\n" +
                    "\n" +
                    "   /deny user:permission\n" +
                    "       Explicitly deny the specified user access rights.\n" +
                    "       This will also remove any explicit grant of the \n" +
                    "       same permissions to the same user.\n" +
                    "\n" +
                    "   /remove[:[g|d]] User \n" +
                    "       Remove all occurrences of User from the acl. \n" +
                    "\t    :g remove all granted rights to that User/Sid.\n" +
                    "\t    :d remove all denied rights to that User/Sid.\n" +
                    "\n" +
                    "    /setintegritylevel [(CI)(OI)]Level \n" +
                    "       Add an integrity ACE to all matching files. \n" +
                    "       level is one of L,M,H (Low Medium or High)\n" +
                    "\t   \n" +
                    "       A Directory Inheritance option for the integrity ACE can precede the level\n" +
                    "       and is applied only to directories:\n" +
                    "\n" +
                    "    /inheritance:e|d|r\n" +
                    "             e - enable inheritance\n" +
                    "             d - disable inheritance and copy the ACEs \n" +
                    "             r - remove all inherited ACEs\n" +
                    "\n" +
                    "   user   A user account, Group or a SID\n" +
                    "\n" +
                    "   /restore  Apply the acls stored in ACLfile to the files in directory\n" +
                    "\n" +
                    "   permission is a permission mask and can be specified in one of two forms:\n" +
                    "        a sequence of simple rights:\n" +
                    "                D - Delete access\n" +
                    "                F - Full access\n" +
                    "                N - No access\n" +
                    "                M - Modify access\n" +
                    "                RX - Read and eXecute access\n" +
                    "                R - Read-only access\n" +
                    "                W - Write-only access\n" +
                    "        a comma-separated list in parenthesis of specific rights:\n" +
                    "                DE - Delete\n" +
                    "                RC - read control\n" +
                    "                WDAC - write DAC\n" +
                    "                WO - write owner\n" +
                    "                S - synchronize\n" +
                    "                AS - access system security\n" +
                    "                MA - maximum allowed\n" +
                    "                GR - generic read\n" +
                    "                GW - generic write\n" +
                    "                GE - generic execute\n" +
                    "                GA - generic all\n" +
                    "                RD - read data/list directory\n" +
                    "                WD - write data/add file\n" +
                    "                AD - append data/add subdirectory\n" +
                    "                REA - read extended attributes\n" +
                    "                WEA - write extended attributes\n" +
                    "                X - execute/traverse\n" +
                    "                DC - delete child\n" +
                    "                RA - read attributes\n" +
                    "                WA - write attributes\n" +
                    "        inheritance rights can precede either form and are applied\n" +
                    "        only to directories:\n" +
                    "                (OI) - object inherit\n" +
                    "                (CI) - container inherit\n" +
                    "                (IO) - inherit only\n" +
                    "                (NP) - don’t propagate inherit\n" +
                    "                (I)  - Permission inherited from parent container\n" +
                    "Unlike earlier command-line tools, iCACLS correctly preserves the canonical ordering of ACE entries:\n" +
                    "\n" +
                    "Explicit Deny\n" +
                    "Explicit Grant\n" +
                    "Inherited Deny\n" +
                    "Inherited Grant\n" +
                    "Access Control Lists apply only to files stored on an NTFS formatted drive, each ACL determines which users (or groups of users) can read or edit the file. When a new file is created it normally inherits ACL's from the folder where it was created.\n" +
                    "\n" +
                    "An access control list (ACL) is a list of access control entries (ACE). When backing up or restoring an ACL with iCACLS, you must do so for an entire directory (using /save and /restore) even if you are only interested in the ACEs for a few individual files. In practice most permissions are set at the per-directory level.\n" +
                    "\n" +
                    "Using iCACLS\n" +
                    "\n" +
                    "To edit a file you must already have the \"Change\" ACL (or be the file's owner)\n" +
                    "To use the iCACLS command to change the permissions of a file requires \"FULL Control\" (or be the file's owner)\n" +
                    "File \"Ownership\" will always override all ACL's - you always have Full Control over files that you create.\n" +
                    "Inherited folder permissions are displayed as:\n" +
                    "\n" +
                    " OI - Object inherit    - This folder and files. (no inheritance to subfolders)\n" +
                    " CI - Container inherit - This folder and subfolders.\n" +
                    " IO - Inherit only      - The ACE does not apply to the current file/directory\n" +
                    "\n" +
                    "These can also be combined as folllows:\n" +
                    " (OI)(CI)\t    This folder, subfolders, and files.\n" +
                    " (OI)(CI)(IO)\tSubfolders and files only.\n" +
                    "     (CI)(IO)  Subfolders only.\n" +
                    " (OI)    (IO)\tFiles only. \n" +
                    "So BUILTIN\\Administrators:(OI)(CI)F means that both files and Subdirectories will inherit 'F' (Full control) \n" +
                    "similarly (CI)R means Directories will inherit 'R' (Read folders only = List permission)\n" +
                    "\n" +
                    "When icacls is applied to the current folder only there is no inheritance and so no output.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "To backup the ACLs of every file in a directory:\n" +
                    "\n" +
                    "icacls * /save Myacl_backup.txt\n" +
                    "\n" +
                    "Restore ACLS using a previously saved acl file:\n" +
                    "\n" +
                    "icacls /restore Myacl_backup.txt\n" +
                    "\n" +
                    "Change the Integrity Level (IL) of a file to High:\n" +
                    "\n" +
                    "icacls MyReport.doc /setintegritylevel H \n" +
                    "\n" +
                    "Remove all inheritance on the 'Demo' folder and grant access to the domain user 'Volta', in this command the /t will traverse existing subfolders and files, and the (CI) will ensure that new folders/files added in future will inherit these permissions:\n" +
                    "\n" +
                    "icacls C:\\Demo /inheritance:r /grant SS64dom\\Volta:(CI)F /t\n" +
                    "\n" +
                    "Grant the group FileAdmins 'Delete' and 'Write DAC' permissions to Sales_Folder:\n" +
                    "\n" +
                    "icacls Sales_Folder /grant FileAdmins:(D,WDAC)\n" +
                    "\n" +
                    "Propagate a new permission to all files and subfolders, without using inheritance:\n" +
                    "(so if any of the subfolders contain specific permissions, those won't be overwritten)\n" +
                    "\n" +
                    "icacls * /grant accountName:(NP)(RX) /T");
        } else if (id == R.id.nav_IEXPRESS) {
            titlte.setText("IEXPRESS.exe");
            content.setText("Create a self extracting ZIP file archive. \n" +
                    "In Windows Vista and greater iexpress.exe must be run with elevated permissions, or from an elevated command prompt.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      IEXPRESS [ /N [/Q] [/M] ] SED_filename\n" +
                    "         [/O:Override_SED_filename, OverrideSectionName] [/D:directory]\n" +
                    "\n" +
                    "Key:\n" +
                    "\n" +
                    "  /N   Build package now (SED filename must be specified)\n" +
                    "  /Q   Quiet mode when using /N\n" +
                    "  /M   Use minimised windows when using /N\n" +
                    "  /O   Specify overrideSED file and section\n" +
                    "  /D   Override directory for exe stub\n" +
                    "\n" +
                    "When running the created self extracting archive, the following options can be used:\n" +
                    "\n" +
                    "  /Q            Quiet mode\n" +
                    "  /T:Full_path  A Temporary working folder\n" +
                    "  /C            Extract files only, when used with /T\n" +
                    "  /C:cmd        Override the install command defined by the author.\n" +
                    "\n" +
                    "  /R:N \t Never restart the computer after installation.\n" +
                    "  /R:A \t Ask to restart the computer after installation.\n" +
                    "  /R:S \t Restart the computer after installation without prompting the user.\n" +
                    "Running IExpress with no options will launch a GUI wizard.\n" +
                    "\n" +
                    "The error message \"Unable to open the report file...\" typically means that iexpress needs to be elevated.\n" +
                    "\n" +
                    "Early versions of iexpress were supplied with the Internet Explorer administration kit (IE 5 and IE 6).\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Create a zip archive:\n" +
                    "\n" +
                    "iexpress.exe\n" +
                    "\n" +
                    "Extract an archive, run any installation program specified and then prompt to reboot:\n" +
                    "\n" +
                    "demo.exe /R:A");
        } else if (id == R.id.nav_LABEL) {
            titlte.setText("LABEL");
            content.setText("Edit a disk label.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      LABEL [/MP][volume] [drive:][label]\n" +
                    "\n" +
                    "Key\n" +
                    "   Drive:  The drive letter of the disk to be named.\n" +
                    "   label   The name for the volume.\n" +
                    "   /MP     Treat the volume as a mount point or volume name.\n" +
                    "   volume  The drive letter, mount point, or volume name.\n" +
                    "           If a volume name is specified, the /MP parameter is unnecessary.\n" +
                    "   /?      Display help. \n" +
                    "Originally designed as a reminder of which floppy disk is in the machine, disk labels can also be applied to hard drives and mapped drives.\n" +
                    "\n" +
                    "A volume label can contain as many as 32 characters for NTFS volumes and as many as 11 characters for FAT volumes and can include spaces but no tabs.\n" +
                    "\n" +
                    "FAT volume labels are not case sensitive and cannot contain any of the following characters: * ? / \\ | . , ; : + = [ ] < > \" This limitation does not apply to NTFS volumes.\n" +
                    "\n" +
                    "If you do not specify a label when you use the label command, label displays a message including the \"Volume Serial Number\" if one exists.\n" +
                    "Disk labels should not be confused with the drive description held in the registry.\n" +
                    "\n" +
                    "Example\n" +
                    "\n" +
                    "To label the disk drive D: as SS64,\n" +
                    "\n" +
                    "C:\\ > label d:SS64\n");
        } else if (id == R.id.nav_LODCTR) {
            titlte.setText("LODCTR.exe");
            content.setText("Load PerfMon performance counters (update registry values).\n" +
                    "\n" +
                    "Syntax:\n" +
                    "      LODCTR option\n" +
                    "\n" +
                    "Options:\n" +
                    "\t  \n" +
                    "   INI-FileName\n" +
                    "      An initialization file that contains  the counter name definitions and\n" +
                    "      explain text for an extensible counter DLL.\n" +
                    "\n" +
                    "   /S:Backup-FileName\n" +
                    "      Save the current perf registry strings and info to Backup-FileName\n" +
                    "\n" +
                    "   /R:Backup-FileName\n" +
                    "      Restore the perf registry strings and info using Backup-FileName\n" +
                    "\n" +
                    "   /R\n" +
                    "      Rebuild the perf registry strings and info from scratch based on the current \n" +
                    "\t     registry settings and backup INI files.\n" +
                    "\t     Often required if Perfmon crashes, or the server is rebooted while perfmon is running.\n" +
                    "\n" +
                    "   /T:Service-Name\n" +
                    "      Set the performance counter service as trusted.\n" +
                    "\n" +
                    "   /E:Service-Name\n" +
                    "      Enable the performance counter service.\n" +
                    "\n" +
                    "   /D:Service-Name\n" +
                    "      Disable the performance counter service.\n" +
                    "\n" +
                    "   /Q\n" +
                    "      Query all performance counter service information\n" +
                    "\n" +
                    "   /Q:Service-Name\n" +
                    "      Query specific performance counter service information.\n" +
                    "\n" +
                    "   /M:Counter-Manifest\n" +
                    "      Install Windows Vista performance counter provider definition XML file to system repository.\n" +
                    "Any arguments with spaces in the names must be enclosed within \"Double Quotation\" marks.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "Rebuild the performance counters:\n" +
                    "\n" +
                    "C:\\> lodctr /r");
        } else if (id == R.id.nav_MAKECAB) {
            titlte.setText("MAKECAB.exe");
            content.setText("Create compressed .CAB file. A .CAB Cabinet file is a Lossless Data Compression format.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      MAKECAB [/V[n]] [/D var=value ...] [/L dir] source [destination]\n" +
                    "\n" +
                    "      MAKECAB [/V[n]] [/D var=value ...] /F directive_file [...]\n" +
                    "\n" +
                    "Key\n" +
                    "   source         File to compress.\n" +
                    "\n" +
                    "   destination    File name to give compressed file.  If omitted, the\n" +
                    "                  last character of the source file name is replaced\n" +
                    "                  with an underscore (_) and used as the destination.\n" +
                    "\n" +
                    "   /F directives  A file containing directives for MAKECAB to use (may be repeated).\n" +
                    "                  If more than one directive file is specified (/F file1 /F file2 ...),\n" +
                    "                  they are processed in the order (left to right) specified on the command line.\n" +
                    "\n" +
                    "                  Variable settings, open cabinets, open disks, etc. are all carried forward\n" +
                    "                  from one directive file to the next (just as if all of the files had been\n" +
                    "                  concatenated together and presented as a single file to MakeCAB).\n" +
                    "                  For example, this is intended to simplify the work for a product shipped\n" +
                    "                  in multiple languages. There would be a short, language-specific directives\n" +
                    "                  file, and then a single, master directives file that covers the bulk of the product.\n" +
                    "\n" +
                    "   /D var=value   Defines variable with specified value. (may be repeated).\n" +
                    "                  Equivalent to using .Set in a directives file.\n" +
                    "                  For example, a single directive file could be used to produce layouts\n" +
                    "                  for different disk sizes by running MakeCAB once with different values of\n" +
                    "                  MaxDiskSize defined: /D MaxDiskSize=1.44M. Both standard MakeCAB variables\n" +
                    "                  and custom variables can be defined in this way.\n" +
                    "\n" +
                    "                  If .Option Explicit is specified in a directive file,\n" +
                    "                  then variable must be defined with a .Define command in a directive file.\n" +
                    "                  To use a variable substitution (as in the directive file with %)\n" +
                    "                  use double %%\n" +
                    "\n" +
                    "   /L dir         Folder location to place destination file (default is current directory).\n" +
                    "                  most useful when destination is not specified.\n" +
                    "\n" +
                    "   /V[n]          Verbosity level (1..3)  1=default, 3=Verbose. ( 0=none undocumented )\n" +
                    "A single CAB file can be used to store a maximum of 65,535 files with a total size of up to 1.99 GiB. To compress multiple files into a single CAB file, use a directive file containing a list of the files to compress and package.\n" +
                    "\n" +
                    "The default destination name is constructed from the source file name plus an extension that can be defined via the CompressedFileExtensionChar variable. ( MAKECAB /D CompressedFileExtensionChar=c )\n" +
                    "\n" +
                    "The MakeCAB defaults are configured for a floppy disk layout.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Create a .CAB archive containing a single file:\n" +
                    "\n" +
                    "C:\\> makecab \"recording.wav\" \"recording.cab\" /L \"C:\\Archive\"\n" +
                    "\n" +
                    "Create a .CAB archive containing multiple files, first create SS64.ddf as a plain text file:\n" +
                    "\n" +
                    ".OPTION EXPLICIT\n" +
                    ";    CabinetNameTemplate is the name of the output CAB file:\n" +
                    ".Set CabinetNameTemplate=Destination.CAB\n" +
                    ".Set Cabinet=on\n" +
                    ".Set Compress=on\n" +
                    "\"file1.dat\"\n" +
                    "\"file2.iso\" \n" +
                    "\"file3.wav\"\n" +
                    "\n" +
                    "C:\\> makecab /F SS64.ddf\n" +
                    "Create a self extracting archive containing movie.mov:\n" +
                    "\n" +
                    "C:\\> makecab movie.mov \"temp.cab\"\n" +
                    "C:\\> copy /b \"%windir%\\system32\\extrac32.exe\"+\"temp.cab\" \"movie.exe\"\n" +
                    "C:\\> del /q /f \"temp.cab\"");
        } else if (id == R.id.nav_MAPISEND) {
            titlte.setText("MAPISEND (Back Office/Exchange Resource kit)");
            content.setText("Send email from the command line.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      MAPISEND -u \"profile\" -p password\n" +
                    "         -r recipient -s \"subject\" -m text message [options]\n" +
                    "\n" +
                    "      MAPISEND -u \"profile\" -p password\n" +
                    "         -r recipient -s \"subject\" -t text_file [options]\n" +
                    "\n" +
                    "Options\n" +
                    "      -i  interactive login (prompts for profile and password)\n" +
                    "      -c  cc: list\n" +
                    "      -f  File Attachment - path and file name(s)\n" +
                    "      -v  generates verbose output (an 8 line summary of the message)\n" +
                    "\n" +
                    "\"profile\" is the profile name (user mailbox) of sender\n" +
                    "\"subject\" is the subject line \n" +
                    "\"recipient\" is one or more recipient(s) \n" +
                    "If more than one recipient - separate with ';' these must not be ambiguous in the default address book.\n" +
                    "Mapisend requires MAPI - i.e the MS Outlook client needs to be installed.\n" +
                    "\n" +
                    "MAPI cannot be used to generate HTML-formatted messages. As an alternative, consider using the Microsoft Outlook Object Model, CDONTS, CDOSYS, CDOEX, or a third-party SMTP control.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "mapisend -u \"MS Exchange Settings\" -p MyPassword -r billg@sun.com -s \"Subject\" -m \"Test message text\"\n" +
                    "\n" +
                    "mapisend -u \"MS Exchange Settings\" -p MyPassword -r billg@hp.com -s \"Subject\" -t c:\\MyMail.txt >> c:\\mail.log");
        } else if (id == R.id.nav_NET) {
            titlte.setText("NET.exe");
            content.setText("The NET Command is used to manage services as follows:\n" +
                    "\n" +
                    "Syntax\n" +
                    "      NET START [service]\n" +
                    "      NET STOP [service]\n" +
                    "      NET PAUSE [service]\n" +
                    "      NET CONTINUE [service] \n" +
                    "   \n" +
                    "Key\n" +
                    "   service : The service name as shown in Control Panel, Services\n" +
                    "To list the basic Services:\n" +
                    "\n" +
                    "NET HELP SERVICES\n" +
                    "\n" +
                    "To list the running Services:\n" +
                    "\n" +
                    "NET START\n" +
                    "\n" +
                    "Error/return codes\n" +
                    "The NET command does not return the documented Win32_Service class return codes (Service Not Active,Service Request Timeout, etc) and for many errors will simply return Errorlevel 2.\n" +
                    "\n" +
                    "It will however echo its own errors on screen:\n" +
                    "\n" +
                    "\"The service table is locked. More help is available by typing NET HELPMSG 2180\"\n" +
                    "\"The service table is full. More help is available by typing NET HELPMSG 2181\"\n" +
                    "\"The requested service has already been started. More help is available by typing NET HELPMSG 2182\"\n" +
                    "\"The service name is invalid. More help is available by typing NET HELPMSG 2185\"\n" +
                    "\"The service is not responding to the control function. NET HELPMSG 2186\" \n" +
                    "\"The service control is busy. NET HELPMSG 2187\" \n" +
                    "\"Invalid service program name. NET HELPMSG 2188\" \n" +
                    "\"The service could not be controlled in its present state. More help is available by typing NET HELPMSG 2189\" \n" +
                    "\"The service ended abnormally. More help is available by typing NET HELPMSG 2190\" \n" +
                    "\"The requested pause or stop is not valid for this service. More help is available by typing NET HELPMSG 2191\"\n" +
                    "\"could not find service name. More help is available by typing NET HELPMSG 2192\"\n" +
                    "\"service control dispatcher pipe read failed. More help is available by typing NET HELPMSG 2193\"\n" +
                    "\"A thread for the new service could not be created. More help is available by typing NET HELPMSG 2194\"\n" +
                    "\n" +
                    "You can detect these errors by searching the output text with an 'old school' FIND command as follows:\n" +
                    "\n" +
                    "NET START alerter 2>&1|FIND \"2182\" \n" +
                    "IF errorlevel 1 goto :sub_already_started");
        } else if (id == R.id.nav_NETDOM) {
            titlte.setText("NETDOM Query (Windows Server 2003/2008/R2/2012 + Windows 7/8)");
            content.setText("Query the domain for information.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      NETDOM QUERY [/Domain:domain] [/Server:server]\n" +
                    "         [/UserD:user] [/PasswordD:[password | *]]\n" +
                    "            [/Verify] [/RESEt] [/Direct] [/SecurePasswordPrompt]\n" +
                    "               WORKSTATION | SERVER | DC | OU | PDC | FSMO | TRUST\n" +
                    "\n" +
                    "Key:\n" +
                    "\n" +
                    "   /Domain     The domain on which to query for the information\n" +
                    "\n" +
                    "   /UserD      User account used to make the connection with the Domain\n" +
                    "               specified by the /Domain argument\n" +
                    "\n" +
                    "   /PasswordD  Password of the user account specified By /UserD.\n" +
                    "               Specifying a * will prompt for the password.\n" +
                    "\n" +
                    "   /Server     Name of a specific domain controller that should be used to\n" +
                    "               perform the query.\n" +
                    "\n" +
                    "   /Verify     For computers, verify that the secure channel between the\n" +
                    "               computer and the domain controller is operating properly.\n" +
                    "               For trusts, verify that the the trust between domains is\n" +
                    "               operating properly. Only outbound trust will be verified. \n" +
                    "               The user must have domain administrator credentials to get\n" +
                    "               correct verification results.\n" +
                    "\n" +
                    "   /RESEt      Reset the secure channel between the computer and the domain\n" +
                    "               controller; valid only for computer enumeration\n" +
                    "\n" +
                    "   /Direct     For a TRUST query: list only the direct trust links and\n" +
                    "               omit the domains indirectly trusted through transitive\n" +
                    "               links. Do not use with /Verify.\n" +
                    "\n" +
                    "   /SecurePasswordPrompt \n" +
                    "               Use secure credentials popup to specify credentials. This\n" +
                    "               option should be used when smartcard credentials need to be\n" +
                    "               specified. This option is only in effect when the password \n" +
                    "               value is supplied as *\n" +
                    "\n" +
                    "   WORKSTATION  Query the domain for the list of workstations\n" +
                    "   SERVER       Query the domain for the list of servers\n" +
                    "   DC           Query the domain for the list of Domain Controllers\n" +
                    "   OU           Query the domain for the list of Organizational Units under\n" +
                    "                which the specified user can create a machine object\n" +
                    "   PDC          Query the domain for the current Primary Domain Controller\n" +
                    "   FSMO         Query the domain for the current list of FSMO owners\n" +
                    "   TRUST        Query the domain for the list of its trusts\n" +
                    "The trust verify command checks only direct, outbound, Windows trusts. To verify an inbound trust, use the NETDOM TRUST command which allows you to specify credentials for the trusting domain.\n" +
                    "\n" +
                    "Netdom options can be abbreviated to just the UPPER case letters, e.g. /PasswordD can be supplied as just /PD");
        } else if (id == R.id.nav_OPENFILES) {
            titlte.setText("OPENFILES.exe");
            content.setText("Query or display open files, disconnect files opened by network users.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      Openfiles.exe /query [/s Computer [/u Domain\\User [/p Password]]]\n" +
                    "        [/fo {TABLE|LIST|CSV}] [/nh] [/v]\n" +
                    "\n" +
                    "      Openfiles.exe /disconnect [/s Computer  [/u Domain\\User [/p Password]]]\n" +
                    "         {[/id OpenFileID]|[/a UserName]|[/o OpenMode]} [/se SessionName] [/op OpenFileName]\n" +
                    "\n" +
                    "Key\n" +
                    "   /s     The name or IP address of a remote computer. (Do not use backslashes.) default=local computer.\n" +
                    "\n" +
                    "   /u     Run the command with the account permissions of user. Default=current logged on user.\n" +
                    "\n" +
                    "   /p     The password of the user account specified with /u.\n" +
                    "\n" +
                    "   /fo    The format to use for the query output. Valid values are TABLE, LIST, and CSV. Default=TABLE.\n" +
                    "\n" +
                    "   /nh    No column headers in the output. Valid only when /fo = TABLE or CSV.\n" +
                    "\n" +
                    "   /id    Disconnect the file opened with the specified numeric OpenFileID on computer\n" +
                    "          Use openfiles.exe /query to learn the file ID.\n" +
                    "          The wildcard (*) can be used to disconnect all open files on computer.\n" +
                    "\n" +
                    "   /a     Disconnect all open files that were accessed by user on computer.\n" +
                    "          The wildcard (*) can be used to disconnect all open files on computer.\n" +
                    "\n" +
                    "   /o     Disconnect all open files with the specified OpenMode on the computer specified by the /s parameter.\n" +
                    "          The OpenMode parameter includes the Read/Write and Read modes.\n" +
                    "          The wildcard (*) can be used to disconnect all open files on computer.\n" +
                    "\n" +
                    "   /se    Disconnect all open files that were created by the specified session on computer.\n" +
                    "          Wildcards (*) can be used. (the /se option is not available under Windows 7)\n" +
                    "\n" +
                    "   /op    Disconnect the open file that was created with the specified OpenFileName on computer \n" +
                    "          The wildcard (*) can be used to disconnect all open files on computer.\n" +
                    "\n" +
                    "   /v     Display verbose information in the output.\n" +
                    "\n" +
                    "   /?     Help.\n" +
                    "Administrator privileges are required to run the OPENFILES command. We can use this fact to detect if the current user is an Admin ( OPENFILES >nul 2>nul will set %ERRORLEVEL% = 1 if the user is not an administrator.) However this will fail when running under WOW64 e.g. running a 32 bit installer on an 64 bit system, so an alternative is to use NET SESSION.\n" +
                    "\n" +
                    "Running openfiles.exe from within powershell allows the output to be easily assigned to a variable.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "From the CMD shell:\n" +
                    "\n" +
                    "C:\\> openfiles /query /fo list /v\n" +
                    "C:\\> openfiles /query /s Server64 /u SS64Dom\\FileAdmin /p password1\n" +
                    "\n" +
                    "C:\\> openfiles /disconnect /o read/write\n" +
                    "C:\\> openfiles /disconnect /op \"c:\\work\\finance.xls\"\n" +
                    "C:\\> openfiles /disconnect /s Server64 /u SS64Dom\\FileAdmin /id 5\n" +
                    "C:\\> openfiles /disconnect /s Server64 /u SS64Dom\\FileAdmin /p password1 /id *\n" +
                    "\n" +
                    "From PowerShell:\n" +
                    "\n" +
                    "PS C:\\> openfiles /query\n" +
                    "PS C:\\> openfiles /query /fo table /nh\n" +
                    "PS C:\\> $file_list = openfiles /query /s Server64 /fo CSV /v /nh \n" +
                    "PS C:\\> openfiles /query /s Server64 /fo CSV /v | ConvertFrom-Csv | Out-GridView\n" +
                    "\n" +
                    "PS C:\\> openfiles /disconnect /id 1\n" +
                    "PS C:\\> openfiles /disconnect /a mike");
        } else if (id == R.id.nav_PATH) {
            titlte.setText("PATH");
            content.setText("Display or set a search path for executable files\n" +
                    "\n" +
                    "Syntax\n" +
                    "      PATH pathname [;pathname] [;pathname] [;pathname]...\n" +
                    "      PATH\n" +
                    "      PATH ;\n" +
                    "\n" +
                    "Key\n" +
                    "   pathname : drive letter and/or folder\n" +
                    "    ;       : the command 'PATH ;' will clear the path\n" +
                    "PATH without parameters will display the current path.\n" +
                    "\n" +
                    "The %PATH% environment variable contains a list of folders. When a command is issued at the CMD prompt, the operating system will first look for an executable file in the current folder, if not found it will scan %PATH% to find it.\n" +
                    "\n" +
                    "Use the PATH command to display or change the list of folders stored in the %PATH% environment variable.\n" +
                    "\n" +
                    "It is important that the pathnames are delimited with semicolons NOT by quotes.\n" +
                    "PowerShell in particular will ignore any path node delimited by double quotes.\n" +
                    "\n" +
                    "To view each item on a single line use this:\n" +
                    "\n" +
                    "for %G in (\"%path:;=\" \"%\") do @echo %G\n" +
                    "\n" +
                    "Or in a batch file:\n" +
                    "\n" +
                    "for %%G in (\"%path:;=\" \"%\") do @echo %%G\n" +
                    "\n" +
                    "To add items to the current path, include %PATH% in your new setting.\n" +
                    "For Example:\n" +
                    "\n" +
                    "PATH=%PATH%;C:\\Program Files\\My Application\n" +
                    "\n" +
                    "Note you do not need to surround each part of the path with double quotes, PATH will treat spaces as part of the filename.\n" +
                    "\n" +
                    "Permanent Changes\n" +
                    "Changes made using the PATH command are NOT permanent, they apply to the current CMD prompt only and remain only until the CMD window is closed.\n" +
                    "\n" +
                    "To permanently change the PATH use \n" +
                    "\n" +
                    "Control Panel, System, Environment, System Variables\n" +
                    "Control Panel, System, Environment, User Variables\n" +
                    "\n" +
                    "The %PATH% variable is set as both a system and user variable, the 2 values are combined to give the PATH for the currently logged in user. This is explained in full by MS Product Support Article Q100843\n" +
                    "\n" +
                    "Be wary of using commands like SETX to modify the PATH - the User path can be edited, but the System path remains read-only for most users. If you try to delete an old value and add a new one it is very common for the 'delete' to fail and the 'add' to succeed, resulting in duplicate values being added to the path.\n" +
                    "\n" +
                    "If you are trying to modify the path to add settings for a single application, a reasonably safe method is to use a second variable:\n" +
                    "e.g.\n" +
                    "\n" +
                    "SetX MYAPP \"C:\\Program Files\\My App\" -m\n" +
                    "\n" +
                    "Now include your new variable in the path like so ...C:\\Windows\\system32;%MYAPP%\n" +
                    "\n" +
                    "You can now easily change that one variable %MYAPP% at any time in the future and the PATH will reflect the new value.\n" +
                    "\n" +
                    "Changing a variable in the Control Panel will not affect any CMD prompt that is already open, only new CMD prompts will get the new setting.\n" +
                    "To change a system variable you must have administrator rights\n" +
                    "If your system has an AUTOEXEC.BAT file then any PATH setting in AUTOEXEC.BAT will also be appended to the %PATH% environment variable. This is to provide compatibility with old installation routines which need to set the PATH. All other commands in AUTOEXEC.BAT are ignored.\n" +
                    "Dpath\n" +
                    "DPATH is an undocumented internal utility that allows the TYPE command to read data files in specified directories as if they were in in the current directory. On some OS's this is also implemented as the now deprecated APPEND command. The list of directories is held in the %DPATH% environment variable which works just like the %PATH% variable, delimited with semicolons (not quotes). Syntax: DPATH pathname [;pathname]...\n" +
                    "\n" +
                    "To type any file on the path:\n" +
                    "\n" +
                    "C:\\batch\\> type win.ini\n" +
                    "The system cannot find the file specified.\n" +
                    "C:\\batch\\> dpath %path% \n" +
                    "C:\\batch\\> type win.ini\n" +
                    "\n" +
                    "Terminology\n" +
                    "For a file stored as:\n" +
                    "C:\\Program Files\\Adobe\\Acrobat.exe\n" +
                    "\n" +
                    "The Drive is:\n" +
                    "C:\n" +
                    "\n" +
                    "The Filename is:\n" +
                    "Acrobat.exe\n" +
                    "\n" +
                    "The Base Name is:\n" +
                    "Acrobat\n" +
                    "\n" +
                    "The File Extension is:\n" +
                    ".exe\n" +
                    "\n" +
                    "The Path is:\n" +
                    "\\Program Files\\Adobe\\\n" +
                    "\n" +
                    "The Full Drive/Pathname is\n" +
                    "C:\\Program Files\\Adobe\\Acrobat.exe\n" +
                    "\n" +
                    "PATH is an internal command.");
        } else if (id == R.id.nav_PATHPING) {
            titlte.setText("PATHPING");
            content.setText("Trace route and provide network latency and packet loss for each router and link in the path. Combines the functionality of PING and TRACERT.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      PATHPING [-n] [-h max_hops] [-g host_list] [-p period]\n" +
                    "         [-q num_queries] [-w timeout] [-i IPAddress] [-4 ] [-6 ][TargetName]\n" +
                    "\n" +
                    "Key\n" +
                    "   -g host_list - Loose source route along host-list.\n" +
                    "   -h max_hops  - Maximum number of hops to search for target.\n" +
                    "   -i address   - Use the specified source address.\n" +
                    "   -n           - Do not resolve addresses to hostnames.\n" +
                    "   -p period    - Wait period milliseconds between pings.\n" +
                    "   -q num_queries - Number of queries per hop.\n" +
                    "   -w timeout   - Wait timeout milliseconds for each reply.\n" +
                    "   -P    - Test for RSVP PATH connectivity.\n" +
                    "   -R    - Test if each hop is RSVP aware.\n" +
                    "   -T    - Test connectivity to each hop with Layer-2 priority tags.\n" +
                    "   -4    - Force using IPv4.\n" +
                    "   -6    - Force using IPv6.\n" +
                    "PathPing is invaluable for determining which routers or subnets are having network problems - it displays the degree of packet loss at any given router or link.\n" +
                    "\n" +
                    "Pathping sends multiple Echo Request messages to each router between a source and destination over a period of time and computes aggregate results based on the packets returned from each router.\n" +
                    "\n" +
                    "Pathping performs the equivalent of the tracert command by identifying which routers are on the path.\n" +
                    "\n" +
                    "To avoid network congestion and to minimize the effect of burst losses, pings should be sent at a sufficiently slow pace (not too frequently.)\n" +
                    "\n" +
                    "When -p is specified, pings are sent individually to each intermediate hop. When -w is specified, multiple pings can be sent in parallel. It's therefore possible to choose a Timeout parameter that is less than the wait Period * Number of hops.\n" +
                    "\n" +
                    "Firewalls\n" +
                    "Like tracert PathPing uses Internet Control Message Protocol (ICMP) over TCP/IP. Many firewalls will block ICMP traffic by default. If an attacker is able to forge ICMP redirect packets, he or she can alter the routing tables on the host and possibly subvert the security of the host by causing traffic to flow via a path you didn't intend.");
        } else if (id == R.id.nav_QGREP) {
            titlte.setText("QGREP (2003 Resource Kit)");
            content.setText("Search file(s) for lines that match a given pattern.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      QGREP [options] [-e string] [-f file] [-i file] [strings] [files]\n" +
                    "\n" +
                    "key:\n" +
                    "      -L     Search strings literally.\n" +
                    "      -X     Treat search strings as regular expressions.\n" +
                    "      -B     Match pattern at beginning of line. \n" +
                    "      -E     Match pattern at end of line. \n" +
                    "      -y     Treat upper and lower-case as equivalent.\n" +
                    "\n" +
                    "      -x     Print lines that match exactly.\n" +
                    "      -l     Print only the file name if the file contains a match.\n" +
                    "      -n     Print line numbers before each matching line.\n" +
                    "      -O     Print seek offset before each matching line.\n" +
                    "      -v     Print only lines that do not contain a match.\n" +
                    "      -z     Print matching lines in MSC error message format. \n" +
                    "\n" +
                    "   -e string Treat the next argument as a literal search string. \n" +
                    "   -f file   Read search strings from file. \n" +
                    "   -i file   Read file list from file. \n" +
                    "   strings   Specifies the search string(s).\n" +
                    "   files     The file(s) to search, which can include wildcard characters\n" +
                    "             (* and ?)\n" +
                    "Examples:\n" +
                    "\n" +
                    "Find either arg1 or arg2 in FileName.txt: \n" +
                    "\n" +
                    "qgrep \"arg1 arg2\" FileName.txt\n" +
                    "\n" +
                    "Find arg1 arg2 in FileName: \n" +
                    "\n" +
                    "qgrep -e \"arg1 arg2\" FileName.txt\n" +
                    "\n" +
                    "White space separates search strings unless the argument is prefixed with -e.\n" +
                    "So to find either \"all\" or \"out\" in x.y, use:\n" +
                    "\n" +
                    "QGREP \"all out\" x.y \n" +
                    "\n" +
                    "While to find \"all out\" use:\n" +
                    "\n" +
                    "QGREP -e \"all out\" x.y \n" +
                    "\n" +
                    "grep is simply an odd concatenation of the phrase \"grab regular expression\"\n");
        } else if (id == R.id.nav_Query_Process_QPROCESS) {
            titlte.setText("Query Process / QPROCESS");
            content.setText("Display information about processes.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      QUERY PROCESS * [/server:ServerName]\n" +
                    "\n" +
                    "      QUERY PROCESS ProgramName [/server:ServerName]\n" +
                    "\n" +
                    "      QUERY PROCESS ProcessID [/server:ServerName]\n" +
                    "\n" +
                    "      QUERY PROCESS SessionName [/server:ServerName]\n" +
                    "\n" +
                    "      QUERY PROCESS /id:nn [/server:ServerName]\n" +
                    "\n" +
                    "Key\n" +
                    "   *           List the processes for all sessions.\n" +
                    "\n" +
                    "   ProcessID   The numeric ID identifying the process that you want to query.\n" +
                    "\n" +
                    "   UserName    The name of the user whose processes you want to list.\n" +
                    "\n" +
                    "   SessionName The name of the session whose processes you want to list.\n" +
                    "\n" +
                    "   /id:nn      The ID of the session whose processes you want to list.\n" +
                    "\n" +
                    "   ProgramName The name of the program whose processes you want to query.\n" +
                    "               The .exe extension is required.\n" +
                    "\n" +
                    "   /server:ServerName\n" +
                    "               The Remote Desktop Session Host server whose processes\n" +
                    "               you want to list.\n" +
                    "               default = server where you are currently logged on.\n" +
                    "\n" +
                    "   /?          Display help.\n" +
                    "QPROCESS is a synonym for QUERY PROCESS.\n" +
                    "\n" +
                    "QUERY PROCESS returns the following information:\n" +
                    "\n" +
                    "The user who owns the process\n" +
                    "The session that owns the process\n" +
                    "The ID of the session\n" +
                    "The name of the process - only the first 12 letters.\n" +
                    "The ID of the process\n" +
                    "If you do not specify a process with UserName, SessionName, or SessionID, then QUERY PROCESS will return only the processes that belong to the current user. When information for multiple processes is returned, a greater than > symbol is displayed before each process that belongs to the current session.\n" +
                    "\n" +
                    "Administrators have full access to all query process functions.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Display information about the processes being used by all sessions:\n" +
                    "\n" +
                    "C:\\> query process *\n" +
                    "\n" +
                    "Display information about the processes being used by session ID 2:\n" +
                    "\n" +
                    "C:\\> query process /ID:2");
        } else if (id == R.id.nav_RASDIAL) {
            titlte.setText("RASDIAL (Dial Up Networking)");
            content.setText("Manage RAS/DUN connections.\n" +
                    "\n" +
                    "Dial a RAS connection:\n" +
                    "   RASDIAL entryname [/PHONEBOOK:PhonebookFile]\n" +
                    "                [/PHONE:PhoneNumber] [username [password|*]] \n" +
                    "                [/CALLBACK:CallBackNumber]\n" +
                    "                [/DOMAIN:domain][/PREFIXSUFFIX]\n" +
                    "\n" +
                    "Hang up a RAS connection:\n" +
                    "   RASDIAL [entryname] /DISCONNECT\n" +
                    "\n" +
                    "Display RAS Status:\n" +
                    "   RASDIAL\n" +
                    "To use this command requires that Dial Up Networking Service be installed (via Control Panel - Networking)\n" +
                    "\n" +
                    "The default location for PhoneBook entries is \\%SystemRoot%\\system32\\ras\\");
        } else if (id == R.id.nav_RASPHONE) {
            titlte.setText("RASPHONE (Dial Up Networking)");
            content.setText("Manage Remote Access Service (RAS) connections.\n" +
                    "This is a part of the Dial-Up Networking service, typically used to connect a PC to an Internet Service Provider.\n" +
                    "\n" +
                    "Dial a RAS connection:\n" +
                    "   RASPHONE [-v] -f PhoneBook_file -d \"PhoneBook_entry\" \n" +
                    "\n" +
                    "Hang up a RAS connection:\n" +
                    "   RASPHONE [-v] -f PhoneBook_file -h \"PhoneBook_entry\" \n" +
                    "\n" +
                    "Display RAS Status dialogue box\n" +
                    "   RASPHONE -S\n" +
                    "\n" +
                    "Other RAS options:\n" +
                    "   RASPHONE [-v] -f PhoneBook_file options \"PhoneBook_entry\"\n" +
                    "\n" +
                    "OPTIONS\n" +
                    "   -a   : Add new PhoneBook entry\n" +
                    "   -e   : Edit an existing PhoneBook entry\n" +
                    "   -c   : Clone an existing PhoneBook entry\n" +
                    "   -r   : Delete/remove an existing PhoneBook entry\n" +
                    "   -v   : Disable - 'grey out' the option to rename the PhoneBook_entry\n" +
                    "To use this command requires that Dial Up Networking Service be installed (via Control Panel - Networking)\n" +
                    "\n" +
                    "The default location for PhoneBook entries is %SystemRoot%\\System32\\ras\\");
        } else if (id == R.id.nav_SC) {
            titlte.setText("SC.exe");
            content.setText("Service Control - Create, Start, Stop, Query or Delete any Windows SERVICE. The command options for SC are case sensitive.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      SC [\\\\server] [command] [service_name] [Options]\n" +
                    "\n" +
                    "Key\n" +
                    "   server       : The machine where the service is running\n" +
                    "\n" +
                    "   service_name : The KeyName of the service, this is often but not always\n" +
                    "                  the same as the DisplayName shown in Control Panel, Services.\n" +
                    "                  You can get the KeyName by running: \n" +
                    "                     SC GetKeyName <DisplayName>\n" +
                    "\n" +
                    "   commands:\n" +
                    "          query  [qryOpt]   Show status\n" +
                    "          queryEx [qryOpt]  Show extended info - pid, flags\n" +
                    "          GetDisplayName    Show the DisplayName\n" +
                    "          GetKeyName        Show the ServiceKeyName\n" +
                    "          EnumDepend        Show Dependencies\n" +
                    "          qc                Show config - dependencies, full path etc\n" +
                    "          start          START a service.\n" +
                    "          stop           STOP a service\n" +
                    "          pause          PAUSE a service.\n" +
                    "          continue       CONTINUE a service.\n" +
                    "          create         Create a service. (add it to the registry)\n" +
                    "          config         permanently change the service configuration\n" +
                    "          delete         Delete a service (from the registry)\n" +
                    "          control        Send a control to a service\n" +
                    "          interrogate    Send an INTERROGATE control request to a service\n" +
                    "          Qdescription   Query the description of a service\n" +
                    "          description    Change the description of a service\n" +
                    "          Qfailure       Query the actions taken by a service upon failure\n" +
                    "          failure        Change the actions taken by a service upon failure\n" +
                    "          sdShow         Display a service's security descriptor using SDDL\n" +
                    "          SdSet          Sets a service's security descriptor using SDDL\n" +
                    "\n" +
                    "   qryOpt:\n" +
                    "          type= driver|service|all\n" +
                    "                         Query specific types of service\n" +
                    "          state= active|inactive|all\n" +
                    "                         Query services in a particular state only\n" +
                    "          bufsize= bytes \n" +
                    "          ri= resume_index_number (default=0)\n" +
                    "          group= groupname\n" +
                    "                         Query services in a particular group\n" +
                    "\n" +
                    "   Misc commands that don’t require a service name:\n" +
                    "          SC  QueryLock  Query the LockStatus for the ServiceManager Database.\n" +
                    "                         this will show if a service request is running\n" +
                    "          SC  Lock       Lock the Service Database\n" +
                    "          SC  BOOT       Values are {ok | bad} Indicates whether to save  \n" +
                    "                         the last restart configuration as the `last-known-good`\n" +
                    "                         restart configuration\n" +
                    "   Options\n" +
                    "     The CREATE and CONFIG commands allow additional service options to be set\n" +
                    "     e.g. to disable a service: SC config \"Name of Service\" start= disabled\n" +
                    "     see the built-in help for more: 'SC create' and 'SC config'\n" +
                    "Note the qryOpt options above are case sensitive - they must be entered in lower case, also the position of spaces and = must be exactly as shown.\n" +
                    "\n" +
                    "The SC command duplicates some aspects of the NET command but adds the ability to create a service.\n" +
                    "SC query will display if a service is running, giving output like this:\n" +
                    "\n" +
                    "        SERVICE_NAME       : messenger\n" +
                    "        TYPE               : 20  WIN32_SHARE_PROCESS\n" +
                    "        STATE              : 4  RUNNING\n" +
                    "                                (STOPPABLE,NOT_PAUSABLE,ACCEPTS_SHUTDOWN)\n" +
                    "        WIN32_EXIT_CODE    : 0  (0x0)\n" +
                    "        SERVICE_EXIT_CODE  : 0  (0x0)\n" +
                    "        CHECKPOINT         : 0x0\n" +
                    "        WAIT_HINT          : 0x0\n" +
                    "To retrieve specific information from SC's output, pipe into FIND or FindStr\n" +
                    "e.g.\n" +
                    "\n" +
                    "  C:\\> SC query messenger | FIND \"STATE\" | FIND \"STOPPED\"\n" +
                    "\n" +
                    "  C:\\> SC query messenger | FIND \"STATE\" | FIND \"RUNNING\"\n" +
                    "The statements above will return an %ERRORLEVEL% = 1 if the text is not found\n" +
                    "\n" +
                    "IF errorlevel 1 GOTO :my_subroutine\n" +
                    "\n" +
                    "The NET START command can be used in a similar way to check if a service is running:\n" +
                    "\n" +
                    "   NET START | FIND \"Service name\" > nul\n" +
                    "   IF errorlevel 1 ECHO The service is not running\n" +
                    "The service control manager will normally wait up to 30 seconds to allow a service to start, you can modify this time (30,000 milliseconds) in the registry\n" +
                    "\n" +
                    "HKLM\\SYSTEM\\CurrentControlSet\\Control\n" +
                    "ServicesPipeTimeout (REG_DWORD)\n" +
                    "\n" +
                    "Some options only take effect at the point when the service is started e.g. the SC config command allows the executable of a service to be changed. When the service next starts up it will run the new executable. Config changes requires the current user to have “permission to configure the service”.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    " SC GetKeyName \"task scheduler\"\n" +
                    " SC GetDisplayName schedule \n" +
                    " SC start schedule\n" +
                    " SC QUERY schedule\n" +
                    " SC CONFIG \"Schedule\" start= disabled\n" +
                    " SC QUERY type= driver\n" +
                    " SC QUERY state= all |findstr \"DISPLAY_NAME STATE\" >svc_installed.txt \n" +
                    " SC \\\\myServer CONFIG myService obj= LocalSystem password= mypassword\n" +
                    " SC CONFIG MyService binPath=c:\\myprogram.exe obj=\".\\LocalSystem\" password=\"\"\n" +
                    "Enable remote registry access on computer64:\n" +
                    " SC \\\\computer64 config remoteregistry start= auto\n" +
                    " SC \\\\computer64 start remoteregistry\n" +
                    "Watch out for extra spaces: \n" +
                    "SC QUERY state= all Works \n" +
                    "SC QUERY state =all Fails! ");
        } else if (id == R.id.nav_SCHTASKS) {
            titlte.setText("SCHTASKS");
            content.setText("Create / edit a Scheduled Job/Task. The job can be created on the local or a remote computer.\n" +
                    "\n" +
                    "Syntax:\n" +
                    "\n" +
                    "   Create a new scheduled task:\n" +
                    "   SCHTASKS /Create [Connect_Options] Create_Options /TN taskname\n" +
                    "\n" +
                    "   Delete the scheduled task(s)\n" +
                    "   SCHTASKS /Delete [Connect_Options] /TN taskname [/F]\n" +
                    "   \n" +
                    "   Display all scheduled tasks:\n" +
                    "   SCHTASKS /Query  [Connect_Options] [/FO format] [/NH] [/V]\n" +
                    "   \n" +
                    "   Run the scheduled task on demand:\n" +
                    "   SCHTASKS /Run [Connect_Options] /TN taskname\n" +
                    "\n" +
                    "   Stop the currently running scheduled task:\n" +
                    "   SCHTASKS /End [Connect_Options] /TN taskname\n" +
                    "\n" +
                    "   Change the properties of scheduled task:\n" +
                    "   SCHTASKS /Change [Connect_Options] {[/RU username] [/RP password] [/TR taskrun]} /TN taskname\n" +
                    "\n" +
                    "   Show the security identifier corresponding to a scheduled task name:\n" +
                    "   SCHTASKS /ShowSID [Connect_Options] /TN taskname\n" +
                    "\n" +
                    " Connect_Options:\n" +
                    "     /S system                      # Remote system (default is local)\n" +
                    "    [/U username [/P password]]     # Submit job under this name\n" +
                    "\n" +
                    " Create_Options:\n" +
                    "    /TR taskrun                     # Pathname of the executable to run\n" +
                    "    /ST starttime                   # HH:MM (24 hour)\n" +
                    "    [/RU username [/RP password]]   # Run job as this user\n" +
                    "    /SC schedule [/MO modifier]     # When to run, see below\n" +
                    "    [/D day]                        # Day = MON,TUE,WED,THU,FRI,SAT,SUN\n" +
                    "    [/M months]                     # Month=JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC.\n" +
                    "    [/I idletime]                   # 1 - 999 minutes (ONIDLE task only)\n" +
                    "    [/SD startdate] [/ED enddate]   # Start / End date in Region specific format e.g. \"12/12/2015\"\n" +
                    "\n" +
                    " options:\n" +
                    "    /TN   A name for the task\n" +
                    "    /F    Force delete, ignore warnings even if the task is currently runnning.\n" +
                    "    /FO   Output format: TABLE, LIST, CSV\n" +
                    "    /NH   No header\n" +
                    "    /V    Verbose output\n" +
                    "\n" +
                    "    /SC schedule  The schedule frequency.\n" +
                    "    Valid schedules: MINUTE, HOURLY, DAILY, WEEKLY, MONTHLY, ONCE, ONSTART,ONLOGON,ONIDLE.\n" +
                    "\n" +
                    "    /MO modifiers allow finer control:\n" +
                    "\n" +
                    "      MINUTE:  1 - 1439 minutes.\n" +
                    "      HOURLY:  1 - 23 hours.\n" +
                    "      DAILY:   1 - 365 days.\n" +
                    "      WEEKLY:  1 - 52 weeks.\n" +
                    "      ONCE:    No modifiers.\n" +
                    "      ONSTART: No modifiers.\n" +
                    "      ONLOGON: No modifiers.\n" +
                    "      ONIDLE:  No modifiers.\n" +
                    "      MONTHLY: 1 - 12, or FIRST, SECOND, THIRD, FOURTH, LAST, LASTDAY.\n" +
                    "New options in Vista and above:\n" +
                    "   /RI interval      # The Repetition Interval in minutes.\n" +
                    "This is not applicable for the following schedule types: MINUTE, HOURLY, ONSTART, ONLOGON,\n" +
                    "ONIDLE, and ONEVENT. The valid range is 1 - 599940 minutes.\n" +
                    "If either the/ET endtime or /DU duration parameters are specified, the default is 10 minutes.\n" +
                    "   /ET endtime       # The End Time to run the task, format is HH:mm (24-hour time).\n" +
                    "For example, 14:50 specifies 2:50PM.\n" +
                    "This is not applicable for the following schedule types: ONSTART, ONLOGON, ONIDLE, and ONEVENT.\n" +
                    "\n" +
                    "/DU duration      # A value that specifies the duration to run the task. \n" +
                    "The time format is HH:mm (24-hour time). For example, 14:50 specifies 2:50PM. This is not applicable with /ET endtime and for the following schedule types: ONSTART, ONLOGON, ONIDLE, and ONEVENT. For /V1 tasks (Task Scheduler 1.0 tasks), if /RI is specified, then the duration default is one hour. This option is available in Windows 2003 or greater (not XP).\n" +
                    "\n" +
                    "/K      # A value that terminates the task at the end time or duration time. \n" +
                    "This is not applicable for the following schedule types: ONSTART, ONLOGON, ONIDLE, and ONEVENT. \n" +
                    "Either /ET endtime or /DU duration must be specified.\n" +
                    "\n" +
                    "/EC ChannelName   # A value that specifies the event channel for ONEVENT triggers.\n" +
                    "/IT A value that enables the task to run interactively only if the /RU user is currently logged on at the time the task runs. The task runs only if the user is logged on.\n" +
                    "\n" +
                    "/NP A value that indicates that no password is stored. The task does not run interactively as the given user. Only local resources are available.\n" +
                    "\n" +
                    "/Z A value that marks the task to be deleted after its final run.\n" +
                    "\n" +
                    "/XML xmlfile A value that creates a task from an XML file. This parameter can be combined with /RU and /RP switches, or with the /RP switch alone when the task XML already contains the principal.\n" +
                    "\n" +
                    "/V1 A value that creates a task visible to Windows 2000, Windows Server 2003, and Windows XP platforms.\n" +
                    "\n" +
                    "/F A value that forcefully creates the task and suppresses warnings if the specified task already exists.\n" +
                    "\n" +
                    "/RL level A value that sets the run level for the task. Valid values are LIMITED and HIGHEST. The default is LIMITED.\n" +
                    "\n" +
                    "/DELAY delaytime A value that specifies the wait time to delay the task after the trigger is fired. The time format is mmmm:ss. This option is only valid for schedule types ONSTART, ONLOGON, and ONEVENT.\n" +
                    "\n" +
                    "Notes\n" +
                    "For MONTHLY schedules give the DAY as a number 1 - 31 (default=1)\n" +
                    "\n" +
                    "To prompt for the password, specify /RP * or /RP none\n" +
                    "\n" +
                    "The User Account under which the Schedule service runs will require specific file access permissions, user permissions and drive mappings.\n" +
                    "\n" +
                    "If the /RU username and /RP Password parameters match the currently logged-in user, the task will run interactively (visible in the foreground).\n" +
                    "\n" +
                    "For the system account, /RU username can be written as \"\", \"NT AUTHORITY\\SYSTEM\" or \"SYSTEM\", a Password is not required. The system account has full access to the local machine but has no permissions on any other machines (or mapped drives) across the Network.\n" +
                    "\n" +
                    "The new task must be set to start a minimum of 1 minute into the future. The /SC option is a little inconsistent, under Windows XP it requires an HH:MM:SS value, under Vista and greater it will accept HH:MM but in all cases the SS value in seconds will be ignored and rounded down.\n" +
                    "\n" +
                    "PowerShell cmdlets\n" +
                    "SCHTASKS.exe is limited to commands with less than 255 characters and does not have access to all of Scheduler 2.0 options such as \"Wake up the machine to run this task\".\n" +
                    "\n" +
                    "These additional options are available via the GUI or by using the Task Scheduler PowerShell cmdlets.\n" +
                    "\n" +
                    "UAC (User Account Control) prompts.\n" +
                    "If a scheduled task invokes a UAC prompt, then the task will fail to run unattended. To prevent this make sure that you select the 'Run With Highest Privileges' check box:\n" +
                    "\n" +
                    "Elevate Scheduled task\n" +
                    "\n" +
                    "Other languages.\n" +
                    "If you are running a non-english language version of Windows then the Days and Months accepted by SCHTASKS might be localised.\n" +
                    "e.g. Italian days: lun, mar, mer, gio, ven, sab, dom Italian months: gen, feb, mar, apr, mag, giu, lug, set, ott, nov, dic.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "Create a task to run at 11 pm every weekday\n" +
                    "\n" +
                    "SCHTASKS /Create /SC weekly /D MON,TUE,WED,THU,FRI /TN MyDailyBackup /ST 23:00 /TR c:\\backup.cmd /RU MyDomain\\MyLogin /RP MyPassword\n" +
                    "Now delete the task:\n" +
                    "\n" +
                    "SCHTASKS /Delete /TN \"MyDailyBackup\" /f\n" +
                    "Create a one-off task to run a script at exactly12 midday:\n" +
                    "\n" +
                    "SCHTASKS /create /tn \"once only\" /tr \"\\\"c:\\my folder\\one.cmd\\\" arguments\" /sc ONCE /sd 12/29/2014 /st 12:00\n" +
                    "Create a daily task to run a script at 5 pm:\n" +
                    "\n" +
                    "SCHTASKS /create /tn \"My Script\" /tr \"\\\"c:\\my folder\\script.cmd\\\" arguments\" /sc daily /sd 12/29/2014 /st 17:00\n" +
                    "Create a task ready to run on demand - this is done by creating a task scheduled far in the past:\n" +
                    "SCHTASKS /create /tn \"On demand demo\" /tr \"C:\\Windows\\notepad.exe\" /sc ONCE /sd 01/01/1910 /st 00:00\n" +
                    "Task Scheduler options are stored in the registry\n" +
                    "\n" +
                    "HKLM\\SOFTWARE\\Microsoft\\SchedulingAgent\\");
        } else if (id == R.id.nav_TAKEOWN) {
            titlte.setText("TAKEOWN");
            content.setText("Take ownership of a file (Windows 2003/7/2008).\n" +
                    "\n" +
                    "Syntax\n" +
                    "      TAKEOWN [/s Computer [/u [Domain\\]UserName [/p [Password]]]]\n" +
                    "         /f FileName [/a] [/r [/d {Y|N}]]\n" +
                    "\n" +
                    "Key\n" +
                    "   /s Computer\n" +
                    "           The name or IP address of a remote computer (do not use backslashes).\n" +
                    "           default = local computer.\n" +
                    "           This parameter applies to all of the files and folders specified in the command.\n" +
                    "\n" +
                    "   /u [Domain\\]UserName\n" +
                    "           Run the script with the permissions of the specified user account.\n" +
                    "           default = system permissions.\n" +
                    "\n" +
                    "   /p [Password]\n" +
                    "           The password of the user account that is specified in the /u parameter.\n" +
                    "\n" +
                    "   /f FileName\n" +
                    "           The file name, UNC path or directory name pattern.\n" +
                    "           Accepts the wildcard character *\n" +
                    "\n" +
                    "   /a      Give ownership to the Administrators group instead of the current user.\n" +
                    "\n" +
                    "   /r      Perform a recursive operation on all files in the specified directory\n" +
                    "           and subdirectories.\n" +
                    "\n" +
                    "   /d {Y | N}\n" +
                    "           Suppress the confirmation prompt that is displayed when the current user\n" +
                    "           does not have the \"List Folder\" permission on a specified directory,\n" +
                    "           and instead use a default value:\n" +
                    "              Y: Take ownership of the directory.\n" +
                    "              N: Skip the directory.\n" +
                    "           Note that you must use this option in conjunction with the /r option.\n" +
                    "If the /a parameter is not specified, file ownership is given to the user who is currently logged on to the computer.\n" +
                    "\n" +
                    "Mixed patterns using (? and *) are not supported by the takeown command.\n" +
                    "\n" +
                    "After changing the owner for a file/folder, you can then assign full permissions to the files and subsequently read or delete them.");
        } else if (id == R.id.nav_TASKLIST) {
            titlte.setText("TASKLIST");
            content.setText("TaskList displays all running applications and services with their Process ID (PID) This can be run on either a local or a remote computer.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      tasklist options\n" +
                    "\n" +
                    "Options:\n" +
                    "\n" +
                    "   /s computer  Name or IP address of a remote computer\n" +
                    "                Don’t use backslashes. Default = local computer.\n" +
                    "\n" +
                    "   /u domain\\user [/p password]]\n" +
                    "                Run under a different account\n" +
                    "\n" +
                    "   /P [password]\n" +
                    "                The password for the given user context. Prompts for input if omitted.\n" +
                    "\n" +
                    "   /M [module]\n" +
                    "                List all tasks currently using the given exe/dll name.\n" +
                    "                If the module name is not specified all loaded modules are displayed.\n" +
                    "\n" +
                    "   /svc         List information for each process without truncation.\n" +
                    "                Valid when /fo=TABLE. Cannot be used with /m or /v\n" +
                    "\n" +
                    "   /M [ModuleName]\n" +
                    "                Show the processes that include the given module.\n" +
                    "\n" +
                    "   /APPS        Display Store Apps and their associated processes. (Windows 8.1+)\n" +
                    "\n" +
                    "   /V           Verbose task information\n" +
                    "\n" +
                    "   /FO {TABLE|LIST|CSV}]\n" +
                    "                Output format, the default is TABLE.\n" +
                    "\n" +
                    "   /NH          No Headers in the output (does not apply to LIST output)\n" +
                    "\n" +
                    "   /FI FilterName [/FI FilterName2 [ ... ]]\n" +
                    "                Apply one of the Filters below:\n" +
                    "\n" +
                    "                   Imagename   eq, ne                  String\n" +
                    "                   PID         eq, ne, gt, lt, ge, le  Positive integer.\n" +
                    "                   Session     eq, ne, gt, lt, ge, le  Any valid session number.\n" +
                    "                   SessionName eq, ne                  String\n" +
                    "                   Status      eq, ne                  RUNNING | NOT RESPONDING\n" +
                    "                   CPUTime     eq, ne, gt, lt, ge, le  Time hh:mm:ss\n" +
                    "                   MemUsage    eq, ne, gt, lt, ge, le  Any valid integer.\n" +
                    "                   Username    eq, ne                  User name ([Domain\\]User).\n" +
                    "                   Services    eq, ne                  String\n" +
                    "                   Windowtitle eq, ne                  String\n" +
                    "                   Modules     eq, ne                  String\n" +
                    "Home editions of Windows do not have TASKLIST, use QPROCESS instead.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "List the services running under each process:\n" +
                    "\n" +
                    "TASKLIST /svc\n" +
                    "\n" +
                    "List the services running under each SvcHost process:\n" +
                    "\n" +
                    "TASKLIST /FI \"imagename eq svchost.exe\" /svc\n" +
                    "\n" +
                    "List the services running now: \n" +
                    "\n" +
                    "TASKLIST /v /fi \"STATUS eq running\"\n" +
                    "\n" +
                    "List the services running under a specific user account: \n" +
                    "\n" +
                    "TASKLIST /v /fi \"username eq SERVICE_ACCT05\"\n");
        } else if (id == R.id.nav_VER) {
            titlte.setText("VER");
            content.setText("Display the current operating system version.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      VER\n" +
                    "Use ver to find specific operating systems like this:\n" +
                    "\n" +
                    "@Echo off\n" +
                    "Setlocal\n" +
                    ":: Get windows Version numbers\n" +
                    "For /f \"tokens=2 delims=[]\" %%G in ('ver') Do (set _version=%%G) \n" +
                    "\n" +
                    "For /f \"tokens=2,3,4 delims=. \" %%G in ('echo %_version%') Do (set _major=%%G& set _minor=%%H& set _build=%%I) \n" +
                    "\n" +
                    "Echo Major version: %_major%  Minor Version: %_minor%.%_build%\n" +
                    "\n" +
                    "if \"%_major%\"==\"5\" goto sub5\n" +
                    "if \"%_major%\"==\"6\" goto sub6\n" +
                    "\n" +
                    "Echo unsupported version\n" +
                    "goto:eof\n" +
                    "\n" +
                    ":sub5\n" +
                    "::Winxp or 2003\n" +
                    "if \"%_minor%\"==\"2\" goto sub_2003\n" +
                    "Echo Windows XP [%PROCESSOR_ARCHITECTURE%]\n" +
                    "goto:eof\n" +
                    "\n" +
                    ":sub_2003\n" +
                    "Echo Windows 2003 or XP 64 bit [%PROCESSOR_ARCHITECTURE%]\n" +
                    "goto:eof\n" +
                    "\n" +
                    ":sub6\n" +
                    "if \"%_minor%\"==\"1\" goto sub7\n" +
                    "Echo Windows Vista or Windows 2008 [%PROCESSOR_ARCHITECTURE%]\n" +
                    "goto:eof\n" +
                    "\n" +
                    ":sub7\n" +
                    "Echo Windows 7 or Windows 2008 R2 [%PROCESSOR_ARCHITECTURE%]\n" +
                    "goto:eof\n" +
                    "A very simple method of version checking is to pipe a version string into FIND, however there is a possibility that something which is a unique string today might match a minor version released in the future e.g. the following would also match 7.6.1\n" +
                    "ver | find \"6.1\" > nul\n" +
                    "if %ERRORLEVEL% == 0 goto ver_2008R2\n" +
                    "List of Windows Version numbers\n" +
                    "Windows 1.0 1.04 \n" +
                    "Windows 2.0 2.11 \n" +
                    "Windows 3.0 3 \n" +
                    "Windows 95 4.0.950\n" +
                    "Windows XP 5.1.2600 \n" +
                    "Windows XP Professional x64 Edition 5.2.3790 \n" +
                    "Windows Home Server 5.2.3790\n" +
                    "Windows Server 2003 5.2.3790 \n" +
                    "Windows Server 2003, Service Pack 1 5.2.3790.1180 \n" +
                    "Windows Server 2003 5.2.3790.1218 \n" +
                    "Windows Vista, RTM (Release to Manufacturing) 6.0.6000.16386 \n" +
                    "Windows Vista 6.0.6000 / Windows Server 2008 6.0.6001 \n" +
                    "Windows Vista, Service Pack 2 / Server 2008 Sp2 6.0.6002 \n" +
                    "Windows 7, RTM (Release to Manufacturing) 6.1.7600.16385 \n" +
                    "Windows 7 6.1.7600 \n" +
                    "Windows 7, Service Pack 1 6.1.7601 \n" +
                    "Windows Server 2008 R2, RTM (Release to Manufacturing) 6.1.7600.16385\n" +
                    "Windows 8, RTM (Release to Manufacturing) 6.2.9200.16384\n" +
                    "Windows 8 6.2.9200\n" +
                    "Windows Server 2012 6.2.9200\n" +
                    "Windows 8.1 6.3.9600.16384.130821-1623\n" +
                    "Windows Server 2012 R2 6.3.9600\n" +
                    "Windows 10 10.0.10240\n" +
                    "See also Wikipedia list of Windows versions\n" +
                    "Service Pack Version\n" +
                    "This Batch script will return the Service Pack level.\n" +
                    "32 bit or 64 bit process detection\n" +
                    "The environment variable PROCESSOR_ARCHITECTURE holds the following possible values:\n" +
                    "\n" +
                    "64-bit process: AMD64 or IA64\n" +
                    "32-bit process or WOW64 (32bit Program on 64 bit OS): x86\n" +
                    "\n" +
                    "If we are running WOW64 then PROCESSOR_ARCHITEW6432 =AMD64\n" +
                    "\n" +
                    "IF PROCESSOR_ARCHITECTURE == x86 AND\n" +
                    "  PROCESSOR_ARCHITEW6432 NOT DEFINED THEN\n" +
                    "  // OS is 32bit\n" +
                    "ELSE\n" +
                    "  // OS is 64bit\n" +
                    "END IF\n" +
                    "\n" +
                    "via David Wang @MSFT\n" +
                    "\n" +
                    "VER is an internal command.");
        } else if (id == R.id.nav_VERIFY) {
            titlte.setText("VERIFY");
            content.setText("To check that files are saved to disk correctly; the system can re-read the disk when saving and verify (compare) with the data in memory.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      VERIFY [ON | OFF]\n" +
                    "By default the CMD shell has verify OFF\n" +
                    "Windows Explorer will always copy with verify ON\n" +
                    "\n" +
                    "Copying files can be up to twice as fast with verify OFF. \n" +
                    "\n" +
                    "VERIFY without a parameter will display the current setting.\n" +
                    "\n" +
                    "\"VERIFY dummy_text\" will set %ERRORLEVEL% to 1\n" +
                    "\n" +
                    "VERIFY is an internal command.");
        } else if (id == R.id.nav_W32TM) {
            titlte.setText("W32TM.exe");
            content.setText("Time Service Utility.\n" +
                    "\n" +
                    "Syntax\n" +
                    "\n" +
                    "  Register the time service, and add default config to the registry\n" +
                    "      W32TM /register\n" +
                    "\n" +
                    "  Unregister the time service, and remove config from the registry\n" +
                    "      W32TM /unregister\n" +
                    "\n" +
                    "  The domain/computers to monitor\n" +
                    "      W32TM /monitor [/domain:domain_name] [/computers:name[,name[,name...]]] [/threads:num]\n" +
                    "\n" +
                    "  Convert a Windows NT system time, in (10^-7)s intervals from 0h 1-Jan 1601, into a readable format.\n" +
                    "      W32TM /ntte NT_Time_Epoch\n" +
                    "\n" +
                    "  Converts a Network Time Protocol (NTP) time, in (2^-32)s intervals from 0h 1-Jan 1900, into a readable format\n" +
                    "      W32TM /ntpte Network_Time\n" +
                    "\n" +
                    "  Tell a computer that it should resynchronize its clock as soon as possible, discarding all accumulated error stats\n" +
                    "      W32TM /resync [/computer:computer] [/nowait] [/rediscover] [/soft]\n" +
                    "\n" +
                    "  Display a strip chart of the offset between this computer and another computer\n" +
                    "      W32TM /stripchart /computer:target [/period:refresh] [/dataonly]\n" +
                    "              [/samples:count] [/packetinfo] [/ipprotocol:<4|6>\n" +
                    "\n" +
                    "  Adjust the configuration of target\n" +
                    "      W32TM /config [/computer:target] [/update] [/manualpeerlist:peers]\n" +
                    "              [/syncfromflags:source] [/LocalClockDispersion:seconds]\n" +
                    "                 [/reliable:(YES|NO)] [/largephaseoffset:milliseconds]\n" +
                    "\n" +
                    "  Display the current time zone settings.\n" +
                    "      W32TM /tz\n" +
                    "\n" +
                    "  Display the values that are associated with a given registry key.\n" +
                    "      (default/root key is HKLM\\System\\CurrentControlSet\\Services\\W32Time)\n" +
                    "      W32TM /dumpreg [/subkey:key] [/computer:target]\n" +
                    "\n" +
                    "  Display a computer's Windows Time service information.\n" +
                    "      W32TM /query [/computer:target] {/source | /configuration | /peers | /status} [/verbose]\n" +
                    "\n" +
                    "  Enable or disable a local computer Windows Time service private log.\n" +
                    "      W32TM /debug {/disable | {/enable /file:name /size:bytes /entries:value [/truncate]}}\n" +
                    "\n" +
                    "\n" +
                    "Options:\n" +
                    "\n" +
                    "   Domain  The domain to monitor. If no domain name is specified, or neither the domain nor\n" +
                    "            computers option is specified, the default domain is used.\n" +
                    "            This option might be used more than once.\n" +
                    "\n" +
                    "   computers Monitor the given list of computers. Computer names are separated by commas, with\n" +
                    "            no spaces. If a name has a prefix of a ‘*’, it is treated as a primary domain\n" +
                    "            controller (PDC). You can use this option more than once.\n" +
                    "\n" +
                    "   computer The computer to act upon, by default the local computer.\n" +
                    "\n" +
                    "   threads  The number of computers to analyze simultaneously. 1-50, default=3.\n" +
                    "\n" +
                    "   NT_Time_Epoch\n" +
                    "            A hex value representing a 64 bit integer that represents the number of seconds\n" +
                    "            elapsed since 1900-01-01 00:00:00 (can be supplied as either Hex or integer)\n" +
                    "            In reverse byte order, the first hex byte is the least significant:\n" +
                    "            (1900-01-01 00:00:01 is encoded as 0x01000000)\n" +
                    "\n" +
                    "   /nowait  Do not wait for the resynchronization to occur; return immediately.\n" +
                    "            Otherwise, wait for the resynchronization to complete before returning.\n" +
                    "\n" +
                    "   /rediscover  Redetect the network configuration and rediscover network sources;\n" +
                    "            then, resynchronize.\n" +
                    "\n" +
                    "   /soft    This option is only provided for compatibility with older time servers and will\n" +
                    "            resynchronize using existing error statistics..\n" +
                    "\n" +
                    "   /period:refresh\n" +
                    "            The time between samples, in seconds. The default value is 2 seconds.\n" +
                    "\n" +
                    "   /Dataonly Display only the data, without graphics.\n" +
                    "\n" +
                    "   /samples:count\n" +
                    "            Collect count samples; then, stop.\n" +
                    "            If a value is not specified, samples will be collected until Ctrl+C is pressed.\n" +
                    "\n" +
                    "   /packetinfo\n" +
                    "            Print out NTP packet response message.\n" +
                    "\n" +
                    "   /Ipprotocol 4|6\n" +
                    "            Specify the IP protocol to use. Default = use whatever is available.\n" +
                    "\n" +
                    "   /update  Notify the time service that the configuration has changed, causing the changes\n" +
                    "            to take effect.\n" +
                    "\n" +
                    "   /manualpeerlist:peers\n" +
                    "            Set the manual peer list to peers, which is a space-delimited list of Domain Name\n" +
                    "            System (DNS) and/or IP addresses. When you are specifying multiple peers, this option\n" +
                    "            must be enclosed in quotation marks (\").\n" +
                    "\n" +
                    "   /syncfromflags:source\n" +
                    "            Sets what sources the NTP client should synchronize from. source should be a\n" +
                    "            comma-separated list of these keywords (not case sensitive):\n" +
                    "              MANUAL — Include peers from the manual peer list.\n" +
                    "              DOMHIER — Synchronize from a domain controller in the domain hierarchy.\n" +
                    "              NO     — Do not synchronize from any server.\n" +
                    "              ALL    — Synchronize from both manual and domain peers.\n" +
                    "\n" +
                    "   /LocalClockDispersion:seconds\n" +
                    "            Configures the accuracy of the internal clock that W32time will assume when\n" +
                    "            it cannot acquire time from its configured sources.\n" +
                    "\n" +
                    "   /reliable:(YES|NO)\n" +
                    "            Set whether this computer is a reliable time source. This setting is meaningful only on domain controllers.\n" +
                    "\n" +
                    "   /largephaseoffset:milliseconds\n" +
                    "            Sets the time difference between local time and network time that W32time will consider to be a spike. \n" +
                    "\n" +
                    "   /source  Display the time source.\n" +
                    "\n" +
                    "   /configuration\n" +
                    "            Display the configuration of run time and where the setting comes from.\n" +
                    "            In verbose mode, display the undefined or unused setting also.\n" +
                    "\n" +
                    "   /peers   Display a list of peers and their status.\n" +
                    "\n" +
                    "   /status  Display Windows Time service status.\n" +
                    "\n" +
                    "   /verbose Set the verbose mode to display more information.\n" +
                    "\n" +
                    "   /disable Disable the private log.\n" +
                    "\n" +
                    "   /enable  Enable the private log.\n" +
                    "              file:name   The absolute file name.\n" +
                    "              size:bytes  The maximum size for circular logging.\n" +
                    "              entries:value  Contains a list of flags, specified by number and separated by commas, that specify\n" +
                    "                             the types of information that should be logged. Valid numbers are 0 to 300.\n" +
                    "                             A range of numbers is valid, in addition to single numbers, such as 0 through 100,103,106.\n" +
                    "                             Value 0-300 is for logging all information.\n" +
                    "   /truncate Truncate the file if it exists.\n" +
                    "\n" +
                    "   /?       Display help.\n" +
                    "The W32Time service is not a full-featured Network Time Protocol (NTP) solution that meets time-sensitive needs.\n" +
                    "\n" +
                    "By default the Windows Time service (w32time) will synchronize its time once per week.\n" +
                    "This can be extended to daily by setting a Scheduled Task to start the service and run w32tm /resync.\n" +
                    "\n" +
                    "The options /debug, /packetinfo and /ipprotocol are available from Windows Vista and above.\n" +
                    "\n" +
                    "/stripchart /packetinfo - will output three timestamps - The first hex number is byte order reversed NTP date, followed by the ANSI date (number of days since 1st Jan 1601) followed by the date/time in readable/local format.\n" +
                    "\n" +
                    "The option /ntpte - will output three timestamps - The first hex number is an NTTE date (as also understood by w32tm.exe /ntte ), followed by the ANSI date (number of days since 1st Jan 1601) followed by the date/time in readable/local format.\n" +
                    "\n" +
                    "The option /ntte - will output two timestamps - first the ANSI date (number of days since 1st Jan 1601) followed by the date/time in readable/local format.\n" +
                    "\n" +
                    "A computer that is a member of a domain is configured by default to synchronize from the domain hierarchy, manually-specified synchronization is most useful for the forest root of the domain or for computers that are not joined to a domain.\n" +
                    "\n" +
                    "Public NTP servers:\n" +
                    "\n" +
                    "NIST Internet Time Service time.nist.gov - part of the NIST Physical Measurement Laboratory, maintains the standard for frequency and time interval for the United States.\n" +
                    "NTP Pool project pool.ntp.org (or \"0.pool.ntp.org 1.pool.ntp.org 2.pool.ntp.org 3.pool.ntp.org\") a big virtual cluster of timeservers.\n" +
                    "time.windows.com - Microsoft's own time server (not particularly reliable).\n" +
                    "Examples:\n" +
                    "\n" +
                    "Set the local Windows Time client to point to two different time servers, one named time.nist.gov and another named pool.ntp.org\n" +
                    "\n" +
                    "W32TM.exe /config /manualpeerlist:\"time.nist.gov pool.ntp.org\" /syncfromflags:manual /update\n" +
                    "Check the Windows Time client configuration from a client computer running Windows 7 that has a host name of PC64\n" +
                    "\n" +
                    "W32TM.exe /query /computer:PC64 /configuration\n" +
                    "\n" +
                    "Convert an NTTE formatted date into a readable format, if using hex, prefix with 0x:\n" +
                    "\n" +
                    "W32TM.exe /ntte 0x01cf070000000000\n" +
                    "\n" +
                    "W32TM.exe /ntte 130330610798428160\n" +
                    "\n" +
                    "Convert an NTP formatted date into a readable format, if using hex, prefix with 0x:\n" +
                    "\n" +
                    "W32TM.exe /ntpte 0x72386aa6917c63d8\n" +
                    "\n");
        } else if (id == R.id.nav_WAITFOR) {
            titlte.setText("WAITFOR.exe (2003 Resource Kit, standard in Windows 7/2008)");
            content.setText("Wait for or send a signal. Waitfor is used to synchronize events between one or more networked computers.\n" +
                    "\n" +
                    "Syntax\n" +
                    "   Wait for a signal:\n" +
                    "      waitfor [/t Timeout] SignalName\n" +
                    "\n" +
                    "   Send a signal:\n" +
                    "      waitfor [/s Computer [/u [Domain\\]User [/p [Password]]]] /si SignalName\n" +
                    "\n" +
                    "Key\n" +
                    "   /s Computer  The name or IP address of the computer to signal\n" +
                    "                (do not include backslashes).\n" +
                    "\n" +
                    "   /u User      Run the script using the credentials of the specified user account.\n" +
                    "                By default, waitfor uses the current user's credentials.\n" +
                    "\n" +
                    "   /p [Password] The password of the user account specified with /u\n" +
                    "\n" +
                    "   /si          Send the signal across the network to waiting machines.\n" +
                    "\n" +
                    "   /t Timeout   Number of seconds to wait for a signal.\n" +
                    "                The valid range is 1 - 99999 (27.7 hours)\n" +
                    "                default = wait indefinitely.\n" +
                    "\n" +
                    "   SignalName   The signal that waitfor waits for or sends.\n" +
                    "                SignalName is not case-sensitive.\n" +
                    "\n" +
                    "   /?           Display help.\n" +
                    "Signal names cannot exceed 225 characters. Valid characters include a-z, A-Z, 0-9, the SignalName is not case-sensitive.\n" +
                    "\n" +
                    "If the command line includes /s Computer, the signal will be broadcast only to the specified system rather than all the computers across the domain. On large domains or wide area networks this will reduce unnecessary network traffic.\n" +
                    "\n" +
                    "To cancel WAITFOR before its timeout has been reached, either launch Waitfor /si signal from a separate command-prompt or KILL the session.\n" +
                    "\n" +
                    "You can run multiple instances of WAITFOR on a single computer, but each instance must wait for a different signal. Only one instance of WAITFOR can wait for a given signal on a given computer. Computers can only receive signals if they are in the same domain as the computer sending the signal.\n" +
                    "\n" +
                    "Batch scripts including WAITFOR can be run as Scheduled tasks under the SYSTEM account.\n" +
                    "\n" +
                    "Typical WAITFOR applications include waiting for large ROBOCOPY jobs to complete, restarting services across a cluster/farm, FTP or BITS downloads, compiling software builds etc.\n" +
                    "\n" +
                    "Examples\n" +
                    "\n" +
                    "Wait for 60 seconds or until the \"simon\" signal is received on the local computer:\n" +
                    "\n" +
                    "C:\\> waitfor /t 60 simon\n" +
                    "\n" +
                    "Activate the \"simon\" signal on the local computer:\n" +
                    "\n" +
                    "C:\\> waitfor /s %computername% /si simon\n" +
                    "\n" +
                    "Wait for 1 hour or until the \"backupComplete\" signal is received on the local computer:\n" +
                    "\n" +
                    "C:\\> waitfor /t 3600 BackupComplete\n" +
                    "\n" +
                    "Activate the \"backupComplete\" signal on the computer Server64:\n" +
                    "\n" +
                    "C:\\> waitfor /s Server64 /si backupComplete");
        } else if (id == R.id.nav_XCACLS) {
            titlte.setText("XCACLS.exe (NT 4 Resource Kit, Windows XP and 2003 - download from Q825751)");
            content.setText("Display or modify Access Control Lists (ACLs) for files and folders. For Vista and greater use icacls.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      XCACLS filename [options]\n" +
                    "\n" +
                    "      XCACLS filename\n" +
                    "\n" +
                    "Key\n" +
                    "   If no options are specified XCACLS will display the ACLs for the file(s)\n" +
                    "\n" +
                    "   options can be any combination of:\n" +
                    "\n" +
                    "   /T       Traverse all subfolders and change all matching files found. \n" +
                    "\n" +
                    "   /E       Edit ACL instead of replacing it. \n" +
                    "\n" +
                    "   /x       Edit ACL instead of replacing it; affect only ACEs that this user already owns*\n" +
                    "\n" +
                    "   /R user  Revoke all access rights from the given user.\n" +
                    "\n" +
                    "   /D user  Deny specified user access, this will over-ride\n" +
                    "            all other permissions the user has.\n" +
                    "\n" +
                    "   /C       Continue on access denied errors. \n" +
                    "   /Y       Replace user's rights without verify\n" +
                    "\n" +
                    "   /P user:permision[;FolderSpec]\n" +
                    "       Replace user's rights. see /G option below\n" +
                    "\n" +
                    "   /G user:permision[;FolderSpec]\n" +
                    "       Grant specified user access rights, permision can be: \n" +
                    "         r  Read \n" +
                    "         c  Change (write) \n" +
                    "         f  Full control\n" +
                    "         p  Change Permissions (Special access)\n" +
                    "         o  Take Ownership (Special access)\n" +
                    "         x  EXecute (Special access)\n" +
                    "         e  REad (Special access)\n" +
                    "         w  Write (Special access)\n" +
                    "         d  Delete (Special access)\n" +
                    "         t  Used only by FolderSpec. see below\n" +
                    "\n" +
                    "* Option only valid in Windows 2003\n" +
                    "FolderSpec is a permission applied to a folder. If FolderSpec is not specified then permission will apply to both files and folders. \n" +
                    "This allows you to set different permissions that will apply (through inheritance) when new files are added to the folder.\n" +
                    "\n" +
                    "FolderSpec = ;T@ where @ is one of the rights above, when this is specified new files will inherit FolderSpec instead of permission. At least one folder access right must follow the T For example ;TF will apply full control (but ;FT is not valid)\n" +
                    "\n" +
                    "Wildcards can be used to specify more that one file in a command. You can specify more than one user in a command. You can combine access rights.\n" +
                    "\n" +
                    "Although taking ownership is listed as an option it does not work, use SUBINACL for this.\n" +
                    "\n" +
                    "Inheritance Errors\n" +
                    "\n" +
                    "\"Permissions incorrectly ordered\" - the quickest way to resolve or avoid these errors is to use the newer iCACLS command instead of XCACLS.\n" +
                    "\n" +
                    "Inherited folder permissions are displayed as:\n" +
                    "\n" +
                    " OI - Object inherit    - This folder and files. (no inheritance to subfolders)\n" +
                    " CI - Container inherit - This folder and subfolders.\n" +
                    " IO - Inherit only      - The ACE does not apply to the current file/directory\n" +
                    "\n" +
                    "These can be combined as folllows:\n" +
                    " (OI)(CI)\t    This folder, subfolders, and files.\n" +
                    " (OI)(CI)(IO)\tSubfolders and files only.\n" +
                    "     (CI)(IO)  Subfolders only.\n" +
                    " (OI)    (IO)\tFiles only. \n" +
                    "So BUILTIN\\Administrators:(OI)(CI)F means that both files and Subdirectories will inherit 'F' (Fullcontrol) \n" +
                    "similarly (CI)R means Directories will inherit 'R' (Read folders only = List permission)\n" +
                    "\n" +
                    "When xcacls is applied to the current folder only there is no inheritance and so no output.\n" +
                    "\n" +
                    "Versions:\n" +
                    "NTFS standards have changed with different versions of Windows and XCACLS has been updated to suit, early versions of Xcacls can give unpredictable results against an NTFS v5 partition.\n" +
                    "\n" +
                    "xcacls.vbs is described in Q825751 and can be downloaded here - xcacls.vbs is an unsupported utility released in 2004 that addresses a limitation with the original xcacls.exe, specifically the inability to append permissions to a folder whose child objects have the inheritance flag set. The .vbs version does not suppport unc paths and is very slow to update multiple ACLs.\n" +
                    "xcacls.vbs includes a version check function \"IsOsSupported()\" and so will not run under Windows 2008.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "Allow guests the right to read and execute in MyFolder\n" +
                    "XCACLS MyFolder /E /G guests:rx\n" +
                    "\n" +
                    "Allow guests the Full Control permission in MyFolder and all subfolders\n" +
                    "XCACLS MyFolder /T /E /G guests:f\n" +
                    "\n" +
                    "Grant guests only read access to all files in and below MyFolder, \n" +
                    "new folders created will be Read Access only, new files will not inherit any rights.\n" +
                    "XCACLS MyFolder /T /P guests:R;Tr \n" +
                    "\n" +
                    "Grant guests only execute access to all files in and below MyFolder\n" +
                    "XCACLS MyFolder /T /P guests:x");
        } else if (id == R.id.nav_XCOPY) {
            titlte.setText("XCOPY");
            content.setText("Copy files and/or directory trees to another folder. XCOPY is similar to the COPY command except that it has additional switches to specify both the source and destination in detail.\n" +
                    "\n" +
                    "Xcopy has been deprecated under Vista and Windows 2008, this means that while still available now it might disappear in a future OS release. To ensure your scripts are 'future proof' use other tools (such as Robocopy) instead of xcopy. \n" +
                    "\n" +
                    "XCOPY is particularly useful when copying files from CDROM to a hard drive, as it will automatically remove the read-only attribute.\n" +
                    "\n" +
                    "Syntax\n" +
                    "      XCOPY source [destination] [options]\n" +
                    "\n" +
                    "Key\n" +
                    "   source      : Pathname for the file(s) to be copied (accepts wildcards).\n" +
                    "\n" +
                    "   destination : Pathname for the new file(s).\n" +
                    "   \n" +
                    "   [options] can be any combination of the following:\n" +
                    "      \n" +
                    "Source Options\n" +
                    "      \n" +
                    "   /A    Copy files with the archive attribute set (default=Y)\n" +
                    "\n" +
                    "   /M    Copy files with the archive attribute set and\n" +
                    "         turn off the archive attribute, use this option\n" +
                    "         when making regular Backups (default=Y)\n" +
                    "                                   \n" +
                    "   /H    Copy hidden and system files and folders (default=N)\n" +
                    "\n" +
                    "   /D:mm-dd-yyyy\n" +
                    "         Copy files changed on or after the specified date.\n" +
                    "         If no date is given, copy only files whose\n" +
                    "         source date/time is newer than the destination time.\n" +
                    "\n" +
                    "   /U    Copy only files that already exist in destination.\n" +
                    "   \n" +
                    "   /S    Copy folders and subfolders\n" +
                    "\n" +
                    "   /E    Copy folders and subfolders, including Empty folders.\n" +
                    "         can be used to modify /T.\n" +
                    "\n" +
                    "   /EXCLUDE:file1[+file2][+file3]...\n" +
                    "\n" +
                    "         The files can each contain one or more full or partial pathnames to be excluded.\n" +
                    "         When any of these match any part of the absolute path of a SOURCE file, then \n" +
                    "         that file will be excluded.\n" +
                    "         For example, specifying a string like \\obj\\ or .obj will exclude\n" +
                    "         all files underneath the directory obj or all files with the\n" +
                    "         .obj extension respectively.\n" +
                    "               \n" +
                    "Copy Options\n" +
                    "               \n" +
                    "   /W    Prompt you to press a key before starting to copy.\n" +
                    "   /P    Prompt before creating each file.\n" +
                    "\n" +
                    "   /Y    Suppress prompt to confirm overwriting a file.\n" +
                    "         can be preset in the COPYCMD env variable.\n" +
                    "   /-Y   Prompt to confirm overwriting a file.\n" +
                    "   \n" +
                    "   /V    Verify that the new files were written correctly.\n" +
                    "   /C    Continue copying even if an error occurs.\n" +
                    "   \n" +
                    "   /I    If in doubt always assume the destination is a folder\n" +
                    "         e.g. when the destination does not exist.\n" +
                    "\n" +
                    "   /B    Copy the Symbolic link itself, not the target of the file.\n" +
                    "\n" +
                    "   /G    Allow the copying of encrypted files to a destination that does not support encryption.\n" +
                    "\n" +
                    "   /J    Copy using unbuffered I/O. Recommended for very large files.\n" +
                    "  \n" +
                    "   /Q    Do not display file names while copying.\n" +
                    "   /F    Display full source and destination file names while copying.\n" +
                    "   /L    List only - Display files that would be copied.\n" +
                    "\n" +
                    "   /Z    Copy files in restartable mode. If the copy is interrupted part way through,\n" +
                    "         it will restart if possible. (use on slow networks)\n" +
                    "\n" +
                    "Destination Options\n" +
                    "\n" +
                    "   /R    Overwrite read-only files.\n" +
                    "\n" +
                    "   /T    Create folder structure, but do not copy files. \n" +
                    "         Do not include empty folders or subfolders. \n" +
                    "          /T /E will include empty folders and subfolders.\n" +
                    "\n" +
                    "   /K    Copy attributes. XCOPY will otherwise reset read-only attributes.\n" +
                    "\n" +
                    "   /N    If at all possible, use only a short filename (8.3) when creating\n" +
                    "         a destination file. This can be necessary when copying between disks\n" +
                    "         that are formatted differently e.g NTFS and VFAT, or when archiving \n" +
                    "         data to an ISO9660 CDROM.\n" +
                    "\n" +
                    "   /O    Copy file Ownership and ACL information.\n" +
                    "\n" +
                    "   /X    Copy file audit settings (implies /O).\n" +
                    "XCOPY will accept UNC pathnames.\n" +
                    "\n" +
                    "To always overwrite destination files use the COPYCMD environment variable: SET COPYCMD=/Y\n" +
                    "\n" +
                    "When comparing Dates/Times the granularity (the finest increment of the timestamp) is 2 seconds for a FAT volume and 0.1 microsecond for an NTFS volume.\n" +
                    "\n" +
                    "Copy a single file\n" +
                    "In most cases copying a single file is best done with the COPY command. When copying a single file with XCOPY, there is no option to indicate if the destination is a filename or a directory (with the filename defaulting to that of the source file).\n" +
                    "In such cases XCOPY will prompt with a (locale specific) message like:\n" +
                    "C:\\> xcopy foo.txt bar.txt\n" +
                    "Does foo.txt specify a file name\n" +
                    "or directory name on the target\n" +
                    "(F = file, D = directory)?\n" +
                    "\n" +
                    "Adding a wildcard (*) to the end of the destination will suppress this prompt and default to copying as a file:\n" +
                    "C:\\> xcopy foo.txt bar.txt*\n" +
                    "C:foo.txt \n" +
                    "1 File(s) copied\n" +
                    "This requires the source and target file extensions to be the same length, typically 3 characters.\n" +
                    "\n" +
                    "Insufficient Memory error\n" +
                    "Attempting to XCOPY a source file that has a pathname longer than the Windows maximum path length (254 characters) will result in a rather unhelpful 'Insufficient Memory' error, the operation will then halt. This bug which has been around for over 10 years makes XCOPY a poor choice for any kind of backup script, use ROBOCOPY instead.\n" +
                    "\n" +
                    "Examples:\n" +
                    "\n" +
                    "Copy a file:\n" +
                    "\n" +
                    "echo F| XCOPY C:\\utils\\MyFile.txt D:\\Backup\\CopyFile.txt\n" +
                    "\n" +
                    "Copy a folder:\n" +
                    "\n" +
                    "XCOPY C:\\utils D:\\Backup\\utils /i\n" +
                    "\n" +
                    "Copy a folder including all subfolders.\n" +
                    "\n" +
                    "XCOPY C:\\utils\\* D:\\Backup\\utils /s /i");
        } else if (id == R.id.nav_principal) {
            fab.setVisibility(View.INVISIBLE);
            titlte.setText("Referências CMD");
            content.setText("     Guia rápido para tirar suas dúvidas sobre comandos de CMD, para você que esta iníciando na carreira do Windows.\n\n     Em breve conteúdo em português.");
        } else {
            fab.setVisibility(View.INVISIBLE);
            titlte.setText("Ops!\nReferências CMD");
            content.setText("Guia rápido para tirar suas dúvidas sobre comandos de CMD, para você que esta iníciando na carreira do Windows.\n\n" +
                    "Em breve este conteúdo estará disponível.");
            //view.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        bar.setTitle(item.getTitle());
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView_);
        scrollView.scrollTo(0, 0);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("content", content.getText().toString());
        outState.putString("title", titlte.getText().toString());
        outState.putString("bar", bar.getTitle().toString());
        outState.putInt("fab", fab.getVisibility());
        super.onSaveInstanceState(outState);
    }
}

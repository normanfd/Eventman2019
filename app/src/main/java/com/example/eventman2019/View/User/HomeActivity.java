package com.example.eventman2019.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.eventman2019.Model.Konveksi;
import com.example.eventman2019.Model.Product;
import com.example.eventman2019.Prevalent.Prevalent;
import com.example.eventman2019.R;
import com.example.eventman2019.View.Admin.AdminMaintenanceActivity;
import com.example.eventman2019.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseReference ProductRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Button konsumsibtn,konveksibtn,logistikbtn;
    private String category= "";

    private String type = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        konveksibtn = (Button) findViewById(R.id.konveksi_btn_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        konveksibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "konveksi";
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            type = getIntent().getExtras().get("Admin").toString();
        }

        Paper.init(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!type.equals("Admin")){
                    Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.user_profile_name);
        CircleImageView profileImageView = headerView.findViewById(R.id.user_profile_image);

        if (!type.equals("Admin")){
            userNameTextView.setText(Prevalent.CurrentOnlineUser.getName());
            Picasso.get().load(Prevalent.CurrentOnlineUser.getImage()).placeholder(R.drawable.ic_person).into(profileImageView);
        }

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        konveksibtn = (Button) findViewById(R.id.konveksi_btn_home);
        konsumsibtn = (Button) findViewById(R.id.konsumsi_btn_home);
        logistikbtn = (Button) findViewById(R.id.logistik_btn_home);

        konveksibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "konveksi";
                ProductRef = FirebaseDatabase.getInstance().getReference().child("Products").child(category);
                FirebaseRecyclerOptions<Product> options =
                        new FirebaseRecyclerOptions.Builder<Product>()
                                .setQuery(ProductRef, Product.class)
                                .build();
                FirebaseRecyclerAdapter<Product, ProductViewHolder> adapter =
                        new FirebaseRecyclerAdapter<Product, ProductViewHolder>(options) {
                            @Override
                            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Product model) {
                                holder.txtProductName.setText(model.getProductname());
                                holder.txtProductDescription.setText(model.getDescription());
                                holder.txtproductPrice.setText("Price : Rp. " + model.getPrice() + " rupiah");
                                Picasso.get().load(model.getImage()).into(holder.imageView);

                                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (type.equals("Admin")){
                                            Intent intent = new Intent(HomeActivity.this, AdminMaintenanceActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category", "konveksi");
                                            startActivity(intent);
                                        }
                                        else {
                                            Intent intent = new Intent(HomeActivity.this,ProductDetailActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category", "konveksi");
                                            startActivity(intent);
                                        }

                                    }
                                });
                            }

                            @NonNull
                            @Override
                            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
                                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent,false);
                                ProductViewHolder holder = new ProductViewHolder(view);
                                return holder;
                            }
                        };
                recyclerView.setAdapter(adapter);
                adapter.startListening();
            }
        });
        konsumsibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "konsumsi";
                ProductRef = FirebaseDatabase.getInstance().getReference().child("Products").child(category);
                FirebaseRecyclerOptions<Product> options =
                        new FirebaseRecyclerOptions.Builder<Product>()
                                .setQuery(ProductRef, Product.class)
                                .build();
                FirebaseRecyclerAdapter<Product, ProductViewHolder> adapter =
                        new FirebaseRecyclerAdapter<Product, ProductViewHolder>(options) {
                            @Override
                            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Product model) {
                                holder.txtProductName.setText(model.getProductname());
                                holder.txtProductDescription.setText(model.getDescription());
                                holder.txtproductPrice.setText("Price : Rp. " + model.getPrice() + " rupiah");
                                Picasso.get().load(model.getImage()).into(holder.imageView);

                                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (type.equals("Admin")){
                                            Intent intent = new Intent(HomeActivity.this, AdminMaintenanceActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category", "konsumsi");
                                            startActivity(intent);
                                        }
                                        else {
                                            Intent intent = new Intent(HomeActivity.this,ProductDetailActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category","konsumsi");
                                            startActivity(intent);
                                        }

                                    }
                                });
                            }

                            @NonNull
                            @Override
                            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
                                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent,false);
                                ProductViewHolder holder = new ProductViewHolder(view);
                                return holder;
                            }
                        };
                recyclerView.setAdapter(adapter);
                adapter.startListening();
            }
        });
        logistikbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "logistik";
                ProductRef = FirebaseDatabase.getInstance().getReference().child("Products").child(category);
                FirebaseRecyclerOptions<Product> options =
                        new FirebaseRecyclerOptions.Builder<Product>()
                                .setQuery(ProductRef, Product.class)
                                .build();
                FirebaseRecyclerAdapter<Product, ProductViewHolder> adapter =
                        new FirebaseRecyclerAdapter<Product, ProductViewHolder>(options) {
                            @Override
                            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Product model) {
                                holder.txtProductName.setText(model.getProductname());
                                holder.txtProductDescription.setText(model.getDescription());
                                holder.txtproductPrice.setText("Price : Rp. " + model.getPrice() + " rupiah");
                                Picasso.get().load(model.getImage()).into(holder.imageView);

                                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (type.equals("Admin")){
                                            Intent intent = new Intent(HomeActivity.this, AdminMaintenanceActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category","logistik");
                                            startActivity(intent);
                                        }
                                        else {
                                            Intent intent = new Intent(HomeActivity.this,ProductDetailActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            intent.putExtra("category", "logistik");
                                            startActivity(intent);
                                        }

                                    }
                                });
                            }

                            @NonNull
                            @Override
                            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
                                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent,false);
                                ProductViewHolder holder = new ProductViewHolder(view);
                                return holder;
                            }
                        };
                recyclerView.setAdapter(adapter);
                adapter.startListening();
            }
        });

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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_cart) {
            if (!type.equals("Admin")){
                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_search) {
            if (!type.equals("Admin")){
                Intent intent = new Intent(HomeActivity.this, SearchProductsActivity.class);
                startActivity(intent);
            }

        }
        else if (id == R.id.nav_categories) {

        }
        else if (id == R.id.nav_settings) {
            if (!type.equals("Admin")){
                Intent intent =new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }

        }
        else if (id == R.id.nav_logout) {
            if (!type.equals("Admin")){
                Paper.book().destroy();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

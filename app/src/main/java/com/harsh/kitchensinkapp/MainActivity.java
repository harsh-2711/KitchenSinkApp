package com.harsh.kitchensinkapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.harsh.searchwidget.Builder.DefaultClientSuggestions;
import com.harsh.searchwidget.Fragments.VoicePermissionDialogFragment;
import com.harsh.searchwidget.Model.ClientSuggestionsModel;
import com.harsh.searchwidget.Model.SearchPropModel;
import com.harsh.searchwidget.SearchBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SearchBar searchBar;
    ArrayList<String> dataFields;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchBar = (SearchBar) findViewById(R.id.searchBar);
        searchBar.setAppbaseClient("https://scalr.api.appbase.io", "shopify-flipkart-test", "xJC6pHyMz", "54fabdda-4f7d-43c9-9960-66ff45d8d4cf", "products");

        dataFields = new ArrayList<>();
        dataFields.add("title");
        dataFields.add("title.search");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_basic);
        final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                .setQueryFormat("or")
                .setHighlight(true)
                .setRedirectIcon(false)
                .setSearchResultImage(false)
                .setHitsEnabled(false)
                .setDebounce(300)
                .setFuzziness("AUTO")
                .build();

        searchBar.setSearchIconVisibility(true);
        searchBar.setClearIconVisibility(false);

        searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
            @Override
            public void onClick(View view, int position, ClientSuggestionsModel result) {

            }

            @Override
            public void onLongClick(View view, int position, ClientSuggestionsModel result) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        navigationView.setCheckedItem(id);

        if (id == R.id.nav_basic) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(false);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_without_search) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(false);
            searchBar.setClearIconVisibility(false);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_with_clear) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_custom_search_icon) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(false);
            searchBar.setSearchIcon(R.drawable.custom_search_icon);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_custom_clear_icon) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(false);
            searchBar.setClearIconVisibility(true);
            searchBar.setClearIcon(R.drawable.delete);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_debounce) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_fuzziness) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("1")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_auto_fuzziness) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_voice_search) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(true);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

            searchBar.setOnSearchActionListener(new SearchBar.OnSearchActionListener() {
                @Override
                public void onSearchStateChanged(boolean enabled) {

                }

                @Override
                public void onSearchConfirmed(CharSequence text) {

                }

                @Override
                public void onButtonClicked(int buttonCode) {
                    if(buttonCode == SearchBar.BUTTON_SPEECH) {
                        if(searchBar.isVoicePermissionGranted()) {
                            searchBar.startVoiceSearch(searchPropModel, new SearchBar.ItemClickListener() {
                                @Override
                                public void onClick(View view, int position, ClientSuggestionsModel result) {
                                    // Handle item click events
                                }

                                @Override
                                public void onLongClick(View view, int position, ClientSuggestionsModel result) {
                                    // Handle long click events
                                }
                            });
                        } else {
                            getSupportFragmentManager().beginTransaction().add(new VoicePermissionDialogFragment(), "Recording Permission").commit();
                        }
                    }
                }
            });

        } else if (id == R.id.nav_without_highlight) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(false)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_round_search) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(true);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_search_result_icon) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_redirect_icon) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(true)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_categories) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(true)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .setCategoryField("tags")
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_max_suggestions_count) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(false)
                    .setSearchResultImage(false)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(6);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_top_categories) {

            searchBar.disableSearch();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(true)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .setCategoryField("tags")
                    .setTopEntries(2)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(5);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_max_default_suggestions) {

            searchBar.disableSearch();

            // Making list of default suggestions
            ArrayList<String> suggestions = new ArrayList<>();
            suggestions.add("Puma T-Shirt");
            suggestions.add("Apple iPhone XS");
            suggestions.add("Nike Trousers");

            // Making list of default categories to be displayed
            ArrayList<String> categories = new ArrayList<>();
            categories.add("T-Shirt");
            categories.add("Mobiles");

            // Setting default suggestions
            ArrayList<ClientSuggestionsModel> defaultSuggestions = new DefaultClientSuggestions(suggestions).setCategories(categories).build();

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(true)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .setCategoryField("tags")
                    .setTopEntries(2)
                    .setDefaultSuggestions(defaultSuggestions)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(5);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        } else if (id == R.id.nav_default_weights) {

            searchBar.disableSearch();

            ArrayList<Integer> weights;

            // Setting weights for dataFields
            weights = new ArrayList<>();
            weights.add(1);
            weights.add(3);

            final SearchPropModel searchPropModel = searchBar.setSearchProp("Demo Widget", dataFields)
                    .setQueryFormat("or")
                    .setHighlight(true)
                    .setRedirectIcon(true)
                    .setSearchResultImage(true)
                    .setHitsEnabled(false)
                    .setDebounce(300)
                    .setFuzziness("AUTO")
                    .setHighlight(true)
                    .setWeights(weights)
                    .build();

            searchBar.setSearchIconVisibility(true);
            searchBar.setClearIconVisibility(true);
            searchBar.setSearchIcon(R.drawable.ic_magnify_black_48dp);
            searchBar.setClearIcon(R.drawable.ic_close_black_48dp);
            searchBar.setSpeechMode(false);
            searchBar.setRoundedSearchBarEnabled(false);
            searchBar.setMaxSuggestionCount(3);

            searchBar.startSearch(searchPropModel, new SearchBar.ItemClickListener() {
                @Override
                public void onClick(View view, int position, ClientSuggestionsModel result) {

                }

                @Override
                public void onLongClick(View view, int position, ClientSuggestionsModel result) {

                }
            });

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
